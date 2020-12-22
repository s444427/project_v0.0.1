import java.util.Arrays;

public class Password {

    private String password;
    private boolean[] checkVar = new boolean[5];

    //    Constructor
    Password(String x) {
        this.password = x;
    }

    public boolean check() {

//        Reset array
        Arrays.fill(this.checkVar, false);

//        length check
        if (this.password.length() >= 8 && this.password.length() <= 20) {
            this.checkVar[0] = true;
        }

//        Small letter, big letter, number, special sign
        for (int i = 0; i < this.password.length(); i++) {
//            Big letter
            if ((int) this.password.charAt(i) >= 65 && (int) this.password.charAt(i) <= 90) {
                this.checkVar[1] = true;
            }
//            Small letter
            if ((int) this.password.charAt(i) >= 97 && (int) this.password.charAt(i) <= 122) {
                this.checkVar[2] = true;
            }
//            Number
            if ((int) this.password.charAt(i) >= 48 && (int) this.password.charAt(i) <= 57) {
                this.checkVar[3] = true;
            }
//            Special sign
            if ((int) this.password.charAt(i) >= 33 && (int) this.password.charAt(i) <= 47) {
                this.checkVar[4] = true;
            }
            if ((int) this.password.charAt(i) >= 58 && (int) this.password.charAt(i) <= 64) {
                this.checkVar[4] = true;
            }
            if ((int) this.password.charAt(i) >= 91 && (int) this.password.charAt(i) <= 96) {
                this.checkVar[4] = true;
            }
            if ((int) this.password.charAt(i) >= 123 && (int) this.password.charAt(i) <= 126) {
                this.checkVar[4] = true;
            }
        }

        for (boolean b : this.checkVar)
            if (!b)
                return false;

            return true;
    }
}
