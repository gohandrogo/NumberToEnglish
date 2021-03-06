package io.handro.Rules;

import io.handro.Rosetta.Tens;
import java.util.ArrayList;

/**
 * Created by alejandrolondono on 6/10/16.
 */
public class TensRules implements Rules {

    TeensRules teensRules = new TeensRules();
    DecimalRules decimalRules = new DecimalRules();

    public static String tens(int digit){
        if(digit == 0) return "";
        return Tens.values()[digit].getValue();
    }

    @Override
    public boolean condition(int input) {
        return input%3 == 1;
    }

    @Override
    public int action(StringBuilder english, ArrayList<Integer> correctedDigits, int iterator){
        if(teensRules.condition(correctedDigits,iterator)){
            teensRules.action(english,correctedDigits,iterator-1);
            if(decimalRules.condition(iterator-1, correctedDigits)) {
                decimalRules.action(english, correctedDigits, iterator);
            }
            iterator--;
        }else {
            english.append(tens(correctedDigits.get(iterator)));
        }
        return iterator;
    }
}
