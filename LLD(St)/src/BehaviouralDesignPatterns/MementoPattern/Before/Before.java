package BehaviouralDesignPatterns.MementoPattern.Before;
import java.util.*;

class ResumeEditor{
    public String name;
    public String education;
    public String experience;
    public List<String> skills;
}
class ResumeSnapsot{
    public String name;
    public String education;
    public String experience;
    public List<String> skills;

    public ResumeSnapsot(ResumeEditor editor){
        this.name = editor.name;
        this.education = editor.education;
        this.experience = editor.experience;
        this.skills = editor.skills;
    }
    public void Restore(ResumeEditor editor){
        this.name = editor.name;
        this.education = editor.education;
        this.experience = editor.experience;
        this.skills = new ArrayList<>(editor.skills);
    }
}
public class Before {
    
}
