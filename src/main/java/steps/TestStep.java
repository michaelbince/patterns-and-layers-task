package steps;

public abstract class TestStep {
    private TestStep nextStep;

    protected abstract void perform();

    public TestStep setNextStep(TestStep nextStep) {
        this.nextStep = nextStep;
        return this;
    }

    public void execute(){
        perform();
        if (nextStep != null) {
            nextStep.execute();
        }
    }
}
