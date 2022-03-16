class ListOperations {
    public static void mergeLists(LinkedList<String> linkedList, ArrayList<String> arrayList) {
        // write your code here
        for (String s : arrayList) {
            linkedList.add(s);
        }
        System.out.printf("The new size of LinkedList is %d%n", linkedList.size());
    }
}