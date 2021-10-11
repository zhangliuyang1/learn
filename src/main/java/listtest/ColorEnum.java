package listtest;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.time.Duration;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/**
 * @Author: zhangliuyang01
 * @Date: 2021/5/6 下午7:16
 */
public enum ColorEnum {
    /**
     *
     */
    GREEN(1) {
        @Override
        String getColor() {
            return "green";
        }
    },
    BLACK(2) {
        @Override
        String getColor() {
            return "black";
        }
    },
    BLUE(3) {
        @Override
        String getColor() {
            return "blue";
        }
    };


    abstract String getColor();

    private int type;

    ColorEnum(int type) {
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public static ColorEnum valueOf(int type) {
        for (ColorEnum value : ColorEnum.values()) {
            if (value.type == type) {
                return value;
            }
        }
        return null;
    }

    public static void main(String[] args) throws ExecutionException {
        System.out.println(ColorEnum.BLACK.getColor());

        LoadingCache<String, String> cache = CacheBuilder.newBuilder().initialCapacity(2).maximumSize(10).expireAfterWrite(Duration.ofSeconds(60)).build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                System.out.println(key);
                return key + "yyy";
            }
        });

        for (int i = 0; i < 10; i++) {
            System.out.println(cache.get(i + ""));
        }
        ConcurrentMap<String, String> map = cache.asMap();
        System.out.println(map);

        for (int i = 0; i < 20; i++) {
            System.out.println(cache.get(i + ""));
        }
        ConcurrentMap<String, String> map1 = cache.asMap();
        System.out.println(map1);

    }
}
