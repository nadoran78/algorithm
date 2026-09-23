import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 장르별 총 재생횟수
        // 장르별 노래 index, 재생횟수
        Map<String, List<Node>> map = new HashMap<>();
        
        for (int i = 0; i < plays.length; i++) {
            Node node = new Node(i, plays[i]);
            
            String genre = genres[i];
            List<Node> list = map.getOrDefault(genre, new ArrayList<Node>());
            list.add(node);
            map.put(genre, list);
        }
        
        String[] distinctGenres = Arrays.stream(genres)
            .distinct()
            .toArray(String[]::new);
        Arrays.sort(distinctGenres, (o1, o2) -> {
            int firstTotal = map.get(o1).stream()
                .mapToInt(node -> node.play)
                .sum();
            
            int secondTotal = map.get(o2).stream()
                .mapToInt(node -> node.play)
                .sum();
            
            return Integer.compare(secondTotal, firstTotal);
        });
        
        List<Integer> result = new ArrayList<>();
        for (String genre : distinctGenres) {
            List<Node> list = map.get(genre).stream()
                .sorted((o1, o2) -> {
                    if (o1.play == o2.play) {
                        return Integer.compare(o1.index, o2.index);
                    }
                    return Integer.compare(o2.play, o1.play);
                })
                .limit(2)
                .collect(Collectors.toList());
            
            for (Node ele : list) {
                result.add(ele.index);
            }
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
    
    class Node {
        int index;
        int play;
        
        public Node(int index, int play) {
            this.index = index;
            this.play = play;
        }
    }
}