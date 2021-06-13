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

    @ModelAttribute("expressions")
    public List<BoExpression> initHistory() throws MathsExceptions { return manager.getExpressions(); }


    /**
    *  Réinitialise le model, en récupérant l'historique de la DB et en mettant une nouvelle expression vide par défaut
    *
    * */
    private void reinitModel(Model model) throws MathsExceptions {
        model.addAttribute("expression", initCalculatrice());
        model.addAttribute("expressions", initHistory());
    }


    /**
    *  Retourne à l'acceuil de la page web (le site n'a qu'une page, il réinitialise donc juste l'interface)
    * */
    @GetMapping("/")
    public String formCalculate(Locale locale, Model model){
        try {
            reinitModel(model);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return MAIN_PAGE;
    }

    /**
     *  Calcule une expression dans l'attribut de model 'expression'
     *  sauvegarde cette expression dans la db
     *  recharge la liste des expressions depuis la db
     * */
    @PostMapping("/calculate")
    public String calculateExpression(@ModelAttribute("expression") @Valid BoExpression expression, Model model){
        try{
            expression.setRes(manager.calculer(expression.getExp()));
            manager.saveExpression(expression);
            model.addAttribute("expressions",manager.getExpressions());
            return MAIN_PAGE;
        } catch(MathsExceptions e){
            logger.error(e.getMessage());
            model.addAttribute("errors", e.getMessage());
            return MAIN_PAGE;
        }
    }


    /**
     * Supprime l'historique
     * */
    @PostMapping("/deleteAll")
    public String deleteAll(@ModelAttribute("expressions") @Valid List<BoExpression> expressions,Model model){
        logger.info("suppression des expressions");
        try {
            manager.deleteAll(expressions);
            reinitModel(model);
        } catch (Exception e){
            logger.error(e.getMessage());
            model.addAttribute("errors", e.getMessage());
        }
        return MAIN_PAGE;
    }
}
