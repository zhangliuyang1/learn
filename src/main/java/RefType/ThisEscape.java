package RefType;

/**
 * @Author: zhangliuyang01
 * @Date: 2020/4/8 16:43
 */
public class ThisEscape {


    public ThisEscape(EventSource source){
        source.registerListener(new EventListener() {
            @Override
            public void onEvent(Event e) {
                doSomething(e);
            }
        });
    }


    void  doSomething(Event e){

    }


    interface EventSource{
        void registerListener(EventListener listener);
    }


    interface EventListener{
        void onEvent(Event e);
    }

    interface Event{

    }
}
