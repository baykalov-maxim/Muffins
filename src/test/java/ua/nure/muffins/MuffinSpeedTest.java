package ua.nure.muffins;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ua.nure.muffins.dao.MuffinDao;
import ua.nure.muffins.dto.MuffinDto;
import ua.nure.muffins.model.Muffin;
import ua.nure.muffins.repository.MuffinJpaRepository;
import ua.nure.muffins.repository.MuffinMongoRepository;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MuffinSpeedTest {

    public static int COUNT_ITERATIONS = 1000;

    @Autowired
    private MuffinJpaRepository muffinJpaRepository;

    @Autowired
    private MuffinMongoRepository muffinMongoRepository;

    @Before
    public void before() {
        muffinMongoRepository.deleteAll();
        muffinJpaRepository.deleteAll();
    }

    @After
    public void after() {
        muffinMongoRepository.deleteAll();
        muffinJpaRepository.deleteAll();

        muffinJpaRepository.save(new Muffin(1, "Маффин с маком", "Очень вкусный маффин. Мы используем специальный мак, после него у вас точно улучшится настроение.", 5, "1"));
        muffinJpaRepository.save(new Muffin(2, "Маффин с шоколадом", "Он тает на языке. Только черный качественный шоколад.", 2, "2"));
        muffinJpaRepository.save(new Muffin(3, "Маффин", "Просто безупречный маффин.", 4, "3"));
        muffinJpaRepository.save(new Muffin(4, "Вкус сессии", "Вместо муки мы использовали кофе. Только для гурманов.", 3, "4"));
    }

    @Test
    public void testJpaIterative() {
        for (int i = 0; i < COUNT_ITERATIONS; i++) {
            Muffin muffin = new Muffin();
            muffin.setId(1000L + i);
            muffin.setName("test" + i);
            muffin.setDesc("test-test-test");
            muffin.setPrice(1000);
            muffin.setImg("1");
            muffinJpaRepository.save(muffin);
        }
    }

    @Test
    public void testJpaList() {
        List<Muffin> muffins = new ArrayList<>();
        for (int i = 0; i < COUNT_ITERATIONS; i++) {
            Muffin muffin = new Muffin();
            muffin.setId(1000L + i);
            muffin.setName("test" + i);
            muffin.setDesc("test-test-test");
            muffin.setPrice(1000);
            muffin.setImg("1");
            muffins.add(muffin);
        }

        muffinJpaRepository.saveAll(muffins);
    }

    @Test
    public void testMongoIterative() {
        for (long i = 0; i < COUNT_ITERATIONS; i++) {
            MuffinDto muffin = new MuffinDto(i, "test" + i, "test-test-test", 1000, "1");
            muffinMongoRepository.save(muffin);
        }
    }

    @Test
    public void testMongoList() {
        List<MuffinDto> muffins = new ArrayList<>();
        for (long i = 0; i < COUNT_ITERATIONS; i++) {
            MuffinDto muffin = new MuffinDto(i, "test" + i, "test-test-test", 1000, "1");
            muffins.add(muffin);
        }

        muffinMongoRepository.saveAll(muffins);
    }
}
