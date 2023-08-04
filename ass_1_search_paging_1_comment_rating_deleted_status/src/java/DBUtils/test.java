/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import DAO.CountItems;
import static java.lang.System.out;
import java.util.List;
import model.Items;

/**
 *
 * @author DELL
 */
public class test {
    public static void main(String[] args) {
        out.print("111");
        CountItems dao = new CountItems();
        List<Items> listt = dao.getItemByPaging(12, 1005); 
        for(Items i: listt) out.println(i.getId()+", "+i.getName()+"");
    }
}
