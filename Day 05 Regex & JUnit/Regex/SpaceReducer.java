public class SpaceReducer {

    public static String reduceSpaces(String input) {
        return input.replaceAll("\\s{2,}", " ");
    }

    public static void main(String[] args) {
        String original = "This   is  an     example     with    multiple      spaces.";
        String modified = reduceSpaces(original);

        System.out.println("Original: \"" + original + "\"");
        System.out.println("Modified: \"" + modified + "\"");
    }
}
