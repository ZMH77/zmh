import java.util.*;

public class demo123{
    public List<KeypointVO> get(List<Keypiont> list){
        List<KeypointVO> listkeypointvo = new ArrayList<>();
        if (list==null) return listkeypointvo;
        Map<Integer,List<KeypointVO>> map = children(list);
        Queue<KeypointVO> queue  =new LinkedList<>();
        List<KeypointVO> list0 = map.get(0);
        if (list0 == null){
            return  listkeypointvo;
        }
        ((LinkedList<KeypointVO>) queue).addAll(list0);
        listkeypointvo.addAll(list0);
        while (!queue.isEmpty()){
            KeypointVO vo = queue.poll();
            if (map.get(vo.getId())!=null){
                List<KeypointVO> children = map.get(vo.getId());
                vo.setChildren(children);
                ((LinkedList<KeypointVO>) queue).addAll(children);

            }

        }
        return listkeypointvo;


    }

    public Map<Integer,List<KeypointVO>> children(List<Keypiont> list){
        Map<Integer,List<KeypointVO>> map = new HashMap<>();
        for (Keypiont k : list){
            if (map.get(k.getParentid())==null){
                List<KeypointVO> res = new ArrayList<>();
                res.add(new KeypointVO(k));
                map.put(k.getParentid(),res);
            }
            if (map.get(k.getParentid())!=null){
                map.get(k.getParentid()).add(new KeypointVO(k));
            }
        }
        return map;
    }



    public void Keypointanswercount(KeypointVO root ,List<problem> list){
        if (list==null || root==null) return;
        if (root.getChildren() == null) return;
        Map<Integer,Integer> map = new HashMap<>();
        for (KeypointVO k :root.getChildren()){
            Keypointanswercount(k,list);
            for (problem p: list){
                if (p.getParentid()==k.getId()){
                    map.put(k.getId(),k.getAnswercount()+1);
                }
            }
            k.setAnswercount(map.get(k.getId()));
            root.setAnswercount(root.getAnswercount()+k.getAnswercount());
        }
    }






    public void fillKeypointCount(KeypointVO root,   Map<Integer,Integer> map) {
        if (root == null) return;
        if (root.getChildren()==null){
            root.setAnswercount(map.getOrDefault(root.getId(), 0));
            return;
        }
        for (KeypointVO k:root.getChildren()){
            fillKeypointCount(k, map);
            root.setCount(root.getCount() + k.getCount()) ;
        }


    }



    public void setr(Map<Integer,List<KeypointVO>> map){

    }
}
