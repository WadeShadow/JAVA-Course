public class CharFrequencyClass {
    private File file;


    public CharFrequencyClass(String fileRoute) {
         file = new File(fileRoute);
        if (!file.isFile())
            throw new IllegalArgumentException("Root doesn't correspond to a file");
    }

    public void computeFrequency() {
        StringBuilder textBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String temString;
            while((temString = reader.readLine())!=null)
            textBuilder.append(temString);
        } catch (IOException ex) {
            System.out.println("I/O Exception " + ex);
        }

        String text = new String(textBuilder).toUpperCase();
        char[] charText = text.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charText.length; ++i) {

            if (isLetter(charText[i])) {
                if (map.containsKey(charText[i])) {
                    map.put(charText[i], map.get(charText[i]) + 1);
                } else {
                    map.put(charText[i], 1);
                }

            }
        }

        System.out.println(map);

    }

    private static boolean isLetter(char a) {
        if (Character.isLetter(a))
            return true;
        return false;
    }




}
