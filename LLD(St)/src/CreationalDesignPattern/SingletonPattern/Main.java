package CreationalDesignPattern.SingletonPattern;

//Eager Loading
//It has its own pros and cons
// class JudgeAnalytics {
//     private static final JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
//     private JudgeAnalytics() {
//     }

//     public static JudgeAnalytics getJudgeAnalytics() {
//         return judgeAnalytics;
//     }
// }

//Lazy Loading, it is not thread safe
//It has its own pros and cons
// class JudgeAnalytics {
//     private static JudgeAnalytics judgeAnalytics;
//     private JudgeAnalytics() {
//     }

//     public static JudgeAnalytics getJudgeAnalytics() {
//         if (judgeAnalytics == null) {
//             judgeAnalytics = new JudgeAnalytics();
//         }
//         return judgeAnalytics;
//     }
// }

// Lazy Loading, it is thread safe but synchronized method is costly as it will block all the threads trying to access the method and it will allow only one thread to access the method at a time
// It has its own pros and cons
// class JudgeAnalytics {
//     private static JudgeAnalytics judgeAnalytics;
//     private JudgeAnalytics() {
//     }

//     public static synchronized JudgeAnalytics getJudgeAnalytics() {
//         if (judgeAnalytics == null) {
//             judgeAnalytics = new JudgeAnalytics();
//         }
//         return judgeAnalytics;
//     }
// }

// Lazy Loading, it is thread safe and synchronized using volatile keyword. Read about volatile keyword, volatile is not thread safe itself
// It has its own pros and cons
class JudgeAnalytics {
    private static volatile JudgeAnalytics judgeAnalytics;
    private JudgeAnalytics() {
    }

    public static JudgeAnalytics getJudgeAnalytics() {
        if (judgeAnalytics == null) {
            synchronized (JudgeAnalytics.class) {
                if (judgeAnalytics == null) {
                    judgeAnalytics = new JudgeAnalytics();
                }
            }
        }
        return judgeAnalytics;
    }
}

// Bill Parg singleton, can be used in Java 5+
// class JudgeAnalytics {
//     private JudgeAnalytics() {
//     }
//     private static class Holder{
//         private static final JudgeAnalytics judgeAnalytics = new JudgeAnalytics();
//     }
//     public static JudgeAnalytics getJudgeAnalytics() {
//         return Holder.judgeAnalytics;
//     }
// }

public class Main {
    public static void main(String[] args) {
        JudgeAnalytics judgeAnalytics = JudgeAnalytics.getJudgeAnalytics();
        JudgeAnalytics judgeAnalytics2 = JudgeAnalytics.getJudgeAnalytics();
        System.out.println("hehe");
        System.out.println(judgeAnalytics);
        System.out.println(judgeAnalytics2);
    }
}
