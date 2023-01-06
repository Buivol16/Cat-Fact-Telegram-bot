package ua.denis.bot.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CatFact {
    private String fact;
    private int length;

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("New fact: ");
        sb.append(getFact())
                .append("\n His length was: ")
                .append(getLength());
        return sb.toString();
    }
}
