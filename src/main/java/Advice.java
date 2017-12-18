import java.lang.reflect.*;

public interface Advice {
    void forwardMethod(Method method);
    void backMethod(Method method);
}
