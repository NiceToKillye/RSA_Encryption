public class Loader {
    public static void main(String[] args) {
        User user1 = new User();
        User user2 = new User();

        String message = "Hello, world!";

        String encoded = user1.encode(message, user2.getPublicKey());
        String decoded = user2.decode(encoded);

        System.out.println("Message: " + message);
        System.out.println("Encoded message: " + encoded);
        System.out.println("Decoded message: " + decoded);

    }
}