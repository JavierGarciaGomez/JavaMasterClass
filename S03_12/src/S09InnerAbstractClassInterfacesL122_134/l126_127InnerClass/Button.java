package S09InnerAbstractClassInterfacesL122_134.l126_127InnerClass;

/**
 * Created by dev on 4/10/2015.
 */
public class Button {
    private String title;
    // Variable de tipo interfaz
    private OnClickListener onClickLister;

    // Constructor
    public Button(String title) {
        this.title = title;
    }

    // Getter
    public String getTitle() {
        return title;
    }

    //
    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickLister = onClickListener;
    }

    public void onClick() {
        this.onClickLister.onClick(this.title);
    }

    // Interface onClickListener
    public interface OnClickListener {
        public void onClick(String title);
    }

}
