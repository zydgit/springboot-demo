package zy.springbootdemo.mvcdemo.validation;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class WorkOverTimeValidator implements ConstraintValidator<WorkOverTime, Integer> {
    WorkOverTime work;
    int max;

    @Override
    public void initialize(WorkOverTime workOverTime) {
        this.work = workOverTime;
        max = work.max();
    }

    @Override
        public boolean isValid(Integer value, ConstraintValidatorContext constraintValidatorContext) {
        if(value == null) {
            return true;
        }
        return value < max;
    }
}
