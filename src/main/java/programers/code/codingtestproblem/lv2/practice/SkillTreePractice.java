package programers.code.codingtestproblem.lv2.practice;

public class SkillTreePractice {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        skill = skill.toUpperCase();

        for(String s : skill_trees) { // BACDE, CBADF, AECB, BDA
            String tmp = "";
            for(char c : s.toCharArray()) { // B A C D E
                if(skill.contains(String.valueOf(c))) tmp = tmp + c; // ""+B -> B+C -> BCD
            }
            if(skill.startsWith(tmp)) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        SkillTreePractice T = new SkillTreePractice();
        System.out.println(T.solution("CBD", new String[]{"BACDE", "CBADF", "AECB", "BDA"}));
    }
}
