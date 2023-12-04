package com.BeerRevoluiton.calculadoraJava;

import com.BeerRevoluiton.calculadoraJava.exceptions.UnsuportedMathOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    @GetMapping("/soma/{numberOne}/{numberTwo}")
    public Double soma(@PathVariable(value="numberOne") String numberOne,@PathVariable(value="numberTwo") String numberTwo) throws Exception{

        // se nao for numerico entra
        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            throw new UnsuportedMathOperation("deu merda , sistema aceita apenas numeros");

        }
        return convertToDouble(numberOne)+convertToDouble(numberTwo);

    }

    @GetMapping("/sub/{numberOne}/{numberTwo}")
    public Double subtracao(@PathVariable(value="numberOne")String numberOne,@PathVariable(value="numberTwo")String numberTwo) throws Exception{
        if(!isNumeric(numberOne)|| !isNumeric(numberTwo)){
            throw new UnsuportedMathOperation("DEU MERDA AQUI , DIGITE SO NUMEROS");
        }
        return convertToDouble(numberOne)-convertToDouble(numberTwo);
    }
    @GetMapping("/div/{numberOne}/{numberTwo}")
    public Double divisao(@PathVariable(value="numberOne")String numberOne,@PathVariable(value="numberTwo")String numberTwo) throws Exception{
        if(!isNumeric(numberOne)|| !isNumeric(numberTwo)){
            throw new UnsuportedMathOperation("DEU MERDA AQUI , DIGITE SO NUMEROS");
        }
        return convertToDouble(numberOne)/convertToDouble(numberTwo);
    }

    @GetMapping("/multi/{numberOne}/{numberTwo}")
    public Double multiplicacao(@PathVariable(value="numberOne")String numberOne,@PathVariable(value="numberTwo")String numberTwo) throws Exception{
        if(!isNumeric(numberOne)|| !isNumeric(numberTwo)){
            throw new UnsuportedMathOperation("DEU MERDA AQUI , DIGITE SO NUMEROS");
        }
        return convertToDouble(numberOne)*convertToDouble(numberTwo);
    }


    private Double convertToDouble(String strNumber) {
        // se vier nulo retorna zero
        if(strNumber == null) return 0D;
        // quando vier numero com virgula , trocar por ponto
        String number = strNumber.replaceAll(",",".");

        // se é numerico , retorna strNumber ParseDouble
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;

    }

    // se é numerico
    private boolean isNumeric(String strNumber) {
        // se vier nulo retorna falso
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",",".");

        // verifica se e numero negativo ou positivo de zero a 9
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");

    }
}
