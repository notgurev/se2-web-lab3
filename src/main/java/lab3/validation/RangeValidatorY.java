package lab3.validation;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("rangeValidatorY")
public class RangeValidatorY implements Validator {
    private static final float MAX_Y = 4;
    private static final float MIN_Y = -4;

    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        float yValue = Float.parseFloat(String.valueOf(o));
        if (yValue <= MIN_Y || yValue >= MAX_Y) throw new ValidatorException(
                new FacesMessage(FacesMessage.SEVERITY_ERROR, null, "Y must be in range (-4 ... 4)")
        );
    }
}
