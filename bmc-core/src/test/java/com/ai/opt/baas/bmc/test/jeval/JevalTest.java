package com.ai.opt.baas.bmc.test.jeval;

import java.util.HashMap;
import java.util.Map;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

public class JevalTest {

    public static void main(String[] args) throws EvaluationException {
        testExp();
    }

    private static void testExp() throws EvaluationException {
        Evaluator evaluator = new Evaluator();
        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        evaluator.setVariables(map);
        System.out.println(evaluator.evaluate("#{a}"));
        System.out.println(evaluator.evaluate("#{a}+#{b}"));
    }

}
