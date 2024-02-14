package jpabook.jpashop.service;

import jakarta.persistence.EntityManager;
import jpabook.jpashop.domain.item.Book;
import jpabook.jpashop.domain.item.Item;
import jpabook.jpashop.repository.ItemRepository;
import jpabook.jpashop.repository.MemberRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired ItemService itemService;
    @Autowired ItemRepository itemRepository;
    @Autowired EntityManager em;

    @Test
    @Rollback(value = false)
    public void 상품등록() throws Exception{
        //given
        Item item = new Book();
        item.setName("바람과 함께 사라지다");
        item.setPrice(10000);
        item.setStockQuantity(10);

        //when
        Long savedId = itemService.saveItem(item);

        //then
        Assertions.assertEquals(item, itemRepository.findOne(savedId));
    }
}