class Solution {
    public String solution(String new_id) {
        new_id = new_id.toLowerCase();
        
        new_id = new_id.replaceAll("[^a-z0-9-_.]", "");
        
        new_id = new_id.replaceAll("\\.+", ".");
        
        if (new_id.startsWith(".")) {
            new_id = new_id.substring(1);
        } 
        if (new_id.endsWith(".")) {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        
        if (new_id.isEmpty()) {
            new_id = "a";
        }
        
        if (new_id.length() >= 16) {
            new_id = new_id.substring(0, 15);
            if (new_id.endsWith(".")) {
                new_id = new_id.substring(0, new_id.length() - 1);
            }
        }
        
        String lastChar= new_id.charAt(new_id.length() - 1) + "";
        
        while (new_id.length() <= 2) {
            new_id += lastChar;
        }
        
        
        return new_id;
    }
}