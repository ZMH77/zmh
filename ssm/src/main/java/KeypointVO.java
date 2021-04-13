import java.util.ArrayList;
import java.util.List;


public class KeypointVO {
    private String name;
    private int count;
    private int answercount;
    private int id;
    private List<KeypointVO> children;

    public int getId() {
        return id;
    }
    public void setChildren(List<KeypointVO> children) {
        this.children = children;
    }
    public List<KeypointVO> getChildren(){
        return children;
    }
    public int getCount(){
        return count;
    }
    public void setCount(int count){
        this.count = count;
    }

    public KeypointVO(Keypiont keypoint) {
        id = keypoint.getId();
        name = keypoint.getName();
        children = new ArrayList<>();
    }

    public int getAnswercount() {
        return answercount;
    }

    public void setAnswercount(int answercount) {
        this.answercount = answercount;
    }
}
