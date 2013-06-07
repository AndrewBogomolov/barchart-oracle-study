package javax.lang.model.element;

import java.util.List;
import javax.lang.model.type.TypeMirror;

public abstract interface ExecutableElement extends Element, Parameterizable
{
  public abstract List<? extends TypeParameterElement> getTypeParameters();

  public abstract TypeMirror getReturnType();

  public abstract List<? extends VariableElement> getParameters();

  public abstract boolean isVarArgs();

  public abstract List<? extends TypeMirror> getThrownTypes();

  public abstract AnnotationValue getDefaultValue();

  public abstract Name getSimpleName();
}

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.lang.model.element.ExecutableElement
 * JD-Core Version:    0.6.2
 */