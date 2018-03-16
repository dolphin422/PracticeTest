package practice.basics;


/**
 * @Description:
 * @Author: jiatai
 * @CreateDate: 2018/3/16 10:39
 */
public class MethodTest {




    /**
     * 根据参数名称复制对象
     *
     * @param _Source the source
     * @param _Target the target
     * @return the object
     */
    private Object copyPropertiesByName(Object _Source, Object _Target) {
        try {
           // BeanUtils.copyProperties(_Source, _Target);

        } catch (Exception ex) {
            System.out.println("copyPropertiesByName出现异常");
        }
        return _Target;
    }
}
