package ex_member_management.beginner;

import java.util.List;

public class Beginner4 {
    public static void main(String[] args) {
           MemberDao dao =new MemberDao();
        List<Member> memberList=dao.findAll(1);

        for(Member ml:memberList){
            System.out.println("name="+ml.getName());
        }
    }
}
