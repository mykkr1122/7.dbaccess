package ex_member_management.beginner;

import java.util.List;

public class Beginner3 {
    public static void main(String[] args) {
        MemberDao dao =new MemberDao();
        List<Member> memberList=dao.findByName("和");

        for(Member ml:memberList){
            System.out.println("name="+ml.getName());
        }
    }
}
