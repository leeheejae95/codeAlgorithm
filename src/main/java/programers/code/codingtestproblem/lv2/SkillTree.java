package programers.code.codingtestproblem.lv2;

public class SkillTree {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        skill = skill.toUpperCase();
        for(String s : skill_trees) {
            String tmp = "";
            for(char c : s.toCharArray()) if(skill.contains(String.valueOf(c))) tmp = tmp + c;
            if(skill.startsWith(tmp)) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        SkillTree T = new SkillTree();
        System.out.println(T.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
