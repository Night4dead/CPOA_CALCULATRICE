package com.iut.as2021.controller.action;

import com.iut.as2021.controller.facade.CalculatriceManager;
import com.iut.as2021.exceptions.MathsExceptions;
import com.iut.as2021.modele.BoExpression;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
@SessionAttributes("expression")
public class ActionCalculate {

    private static final Logger logger = Logger.getLogger(ActionCalculate.class);

    private static final java.lang.String REDIRECT_DEFAULT = "redirect:/";
    private static final java.lang.String MAIN_PAGE = "calculatrice";

    @Autowired
    private CalculatriceManager manager;

    @ModelAttribute("expression")
    public BoExpression initCalculatrice() { return new BoExpression();}

    private void reinitModel(Model model) throws MathsExceptions { model.addAttribute("expression", initCalculatrice()); }

    @GetMapping("/")
    public String formCalculate(Locale locale, Model model){
        try {
            model.addAttribute("message","Welcome !");
            model.addAttribute("expression",initCalculatrice());
            model.addAttribute("expressions",manager.getExpressions());
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return MAIN_PAGE;
    }

    @PostMapping("/calculate")
    public String calculateExpression(@ModelAttribute("expression") @Valid BoExpression expression, Model model){
        try{
            model.addAttribute("expressions",manager.getExpressions());
            logger.info("l'expression est : "+expression.getExp());
            expression.setRes(manager.calculer(expression.getExp()));
            manager.saveExpression(expression);
            return MAIN_PAGE;
        } catch(MathsExceptions e){
            logger.error(e.getMessage());
            model.addAttribute("errors", e.getMessage());
            return MAIN_PAGE;
        }
    }

    @GetMapping("/deleteAll")
    public String deleteAll(Model model){
        logger.info("suppression des expressions");
        try {
            manager.deleteAll();
            reinitModel(model);
        } catch (Exception e){
            logger.error(e.getMessage());
            model.addAttribute("errors", e.getMessage());
        }
        return MAIN_PAGE;
    }
}
