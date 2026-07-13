package CreationalDesignPattern.SingletonPattern.Before;

class JudgeAnalytics {
    private int run = 0;
    private int submit = 0;
    public void countRun() {
        run++;
    }
    public void countSubmit() {
        submit++;
    }
    public int getRunCount() {
        return run;
    }
    public int getSubmitCount() {
        return submit;
    }
}
public class Before {
    public static void main(String[] args) {
        JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
        judgeAnalytics.countRun();
        judgeAnalytics.countSubmit();
        System.out.println("Run Count: " + judgeAnalytics.getRunCount());
        System.out.println("Submit Count: " + judgeAnalytics.getSubmitCount());

        JudgeAnalytics judgeAnalytics2 = new JudgeAnalytics();
        judgeAnalytics2.countRun();
        judgeAnalytics2.countSubmit();
        System.out.println("Run Count: " + judgeAnalytics2.getRunCount());
        System.out.println("Submit Count: " + judgeAnalytics2.getSubmitCount());
    }
}
