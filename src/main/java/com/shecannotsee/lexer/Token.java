package src.main.java.com.shecannotsee.lexer;

import java.util.ArrayList;
import java.util.Objects;

public class Token {
    Token() {
        value = "";
        type = TokenType.VALUE;
    }
    private String value;
    private TokenType type;

    public String getValue() {
        return value;
    }
    public void setValue(char value) {
        this.value += value;
    }

    public TokenType getType() {
        return type;
    }
    public void setType(TokenType type) {
        this.type = type;
    }

    static private Token checkAndAdd(Token temp, ArrayList<Token> TokenStream, char ch, TokenType type) {
        // if value not empty, would add to ArrayList
        if (!temp.value.isEmpty()) {
            TokenStream.add(temp);
            temp = new Token();
        }
        temp.setValue(ch);
        temp.setType(type);
        TokenStream.add(temp);
        temp = new Token();
        return temp;
    }

    static public ArrayList<Token> generate(String characterStream) {
        ArrayList<Token> TokenStream = new ArrayList<>();

        Token temp = new Token();
        for (char ch : characterStream.toCharArray()) {
            /**/ if (Objects.equals(ch, Constants.FUNCTION_START)) {
                Token.checkAndAdd(temp, TokenStream, ch, TokenType.FUNCTION_START);
            }
            else if (Objects.equals(ch, Constants.FUNCTION_END)) {
                Token.checkAndAdd(temp, TokenStream, ch, TokenType.FUNCTION_END);
            }
            else if (Objects.equals(ch, Constants.PARAM_START)) {
                Token.checkAndAdd(temp, TokenStream, ch, TokenType.PARAM_START);
            }
            else if (Objects.equals(ch, Constants.PARAM_END)) {
                Token.checkAndAdd(temp, TokenStream, ch, TokenType.PARAM_END);
            }
            else if (Objects.equals(ch, Constants.BODY_START)) {
                Token.checkAndAdd(temp, TokenStream, ch, TokenType.BODY_START);
            }
            else if (Objects.equals(ch, Constants.BODY_END)) {
                Token.checkAndAdd(temp, TokenStream, ch, TokenType.BODY_END);
            }
            else if (Objects.equals(ch, Constants.SEMICOLON)) {
                Token.checkAndAdd(temp, TokenStream, ch, TokenType.SEMICOLON);
            }
            else if (Objects.equals(ch, Constants.SPACE)) {
                Token.checkAndAdd(temp, TokenStream, ch, TokenType.SPACE);
            }
            else if (Objects.equals(ch, Constants.LINE_BREAK)) {
                Token.checkAndAdd(temp, TokenStream, ch, TokenType.LINE_BREAK);
            }
            else if (Objects.equals(ch, Constants.NOTE)) {
                Token.checkAndAdd(temp, TokenStream, ch, TokenType.NOTE);
            }
            else {
                temp.value += ch;
                temp.type = TokenType.VALUE;
            }
        }
        TokenStream.add(temp);

        return TokenStream;
    }
}

class Constants {
    public static final char FUNCTION_START   = '[';
    public static final char FUNCTION_END     = ']';
    public static final char PARAM_START      = '(';
    public static final char PARAM_END        = ')';
    public static final char BODY_START       = '{';
    public static final char BODY_END         = '}';
    public static final char SEMICOLON        = ';';
    public static final char SPACE            = ' ';
    public static final char LINE_BREAK       = 'n';
    public static final char NOTE             = '#';

}

enum TokenType {
    FUNCTION_START,  // function start like '['
    FUNCTION_END,  // function end like ']'
    PARAM_START,  // param start like '('
    PARAM_END,  // param end like ')'
    BODY_START,  // statement start like '{'
    BODY_END,  // statement end like '}'
    SEMICOLON,  // Separation of parameters or statements like ';'
    SPACE,  // just space
    LINE_BREAK,  // '\n' or '\r\n'
    NOTE,  // note like '#'
    VALUE,  // value

}
