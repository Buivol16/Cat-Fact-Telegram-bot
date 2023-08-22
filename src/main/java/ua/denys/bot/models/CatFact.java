package ua.denys.bot.models;


public record CatFact(String fact, int length) {
    @Override
    public String toString() {
        String text = "New fact: " + fact();
        String length = "His length was: " + length();
        return text + "\n" + length;
    }
}
