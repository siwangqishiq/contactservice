package xyz.panyi.contactservice.service;

import org.springframework.stereotype.Service;
import xyz.panyi.contactservice.controller.Util;
import xyz.panyi.contactservice.model.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class ContactService {
    private static final Random rnd = new Random();
    private List<Contact> cachedList = Collections.EMPTY_LIST;

    public List<Contact> genContactList(int count){
        if(cachedList.size() >= count){
            return cachedList.subList(0 , count);
        }

        List<Contact> list = new ArrayList<Contact>();
        for(int i = 0 ; i < count;i++){
            Contact contact = new Contact();
            contact.setUid(100 + i);
            contact.setName(Util.getName());
            contact.setSex((rnd).nextInt() %2 ==0?(byte)1:0);
            contact.setIcon("https://picsum.photos/200");
            contact.setDesc(Util.generateRandomString(rnd.nextInt(200)));
            contact.setJobNo(contact.getUid()+"");
            contact.setDepartmentId(Util.generateRandomString(8));
            contact.setPosition(Util.generateRandomString(16));

            contact.setCreateTime(System.currentTimeMillis() - 2000);
            contact.setUpdateTime(System.currentTimeMillis());
            list.add(contact);
        }//end for i
        cachedList = list;
        return list;
    }
}
