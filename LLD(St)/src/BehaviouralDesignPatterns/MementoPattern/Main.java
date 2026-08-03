package BehaviouralDesignPatterns.MementoPattern;
import java.util.*;

class ResumeEditor{
    private String name;
    private String education;
    private String experience;
    private List<String> skills;

    public void setName(String name){
        this.name = name;
    }
    public void setEducation(String education){
        this.education = education;
    }
    public void setExperience(String experience){
        this.experience = experience;
    }
    public void setSkill(List<String> skills){
        this.skills = skills;
    }
    public void printResume(){
        System.out.println("----Resume----");
        System.out.println("Name: " + name);
        System.out.println("Education: " + education);
        System.out.println("Experience: " + experience);
        System.out.println("Skills: " + String.join(", ", skills));
        System.out.println("---------------");
    }
    public Memento save(){
        return new Memento(name, education, experience, List.copyOf(skills));
    }

    public void restore(Memento memento){
        this.name = memento.name;
        this.education = memento.education;
        this.experience = memento.experience;
        this.skills = memento.getSkills();
    }

    public static class Memento{
        private final String name;
        private final String education;
        private final String experience;
        private final List<String> skills;

        private Memento(String name, String education, String experience, List<String> skills){
            this.name = name;
            this.education = education;
            this.experience = experience;
            this.skills = skills;
        }
        private String getName(){
            return name;
        }
        private String getEducation(){
            return education;
        }
        private String getExperience(){
            return experience;
        }
        private List<String> getSkills(){
            return skills;
        }
    }
}

class ResumeHistory{
    private Stack<ResumeEditor.Memento> history = new Stack<>();
    public void save(ResumeEditor editor){
        history.push(editor.save());
    }
    public void undo(ResumeEditor editor){
        if(!history.isEmpty())
            editor.restore(history.pop());
    }
}


public class Main {
    public static void main(String[] args) {
        ResumeEditor editor = new ResumeEditor();
        ResumeHistory history = new ResumeHistory();

        editor.setName("John Doe");
        editor.setEducation("Bachelor of Science in Computer Science");
        editor.setExperience("2 years of experience in software development");
        editor.setSkill(Arrays.asList("Java", "Python", "SQL"));
        history.save(editor);

        editor.setExperience("3 years of experience in software development");
        editor.setSkill(Arrays.asList("Java", "Python", "SQL", "C++"));
        history.save(editor);

        editor.printResume();

        history.undo(editor);
        editor.printResume();   
        
        history.undo(editor);
        editor.printResume();
    }
}
