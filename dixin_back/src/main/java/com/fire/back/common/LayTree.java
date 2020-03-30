package com.fire.back.common;

import com.fire.back.entity.SysMenu;

import java.io.Serializable;
import java.util.List;

public class LayTree implements Serializable {

    private static final long serialVersionUID = 1L;

    public LayTree(){}

    public LayTree(SysMenu menu){
        this.id = menu.getMenuId();
        this.title =transMenuName(menu);
    }
    public String transMenuName(SysMenu menu)
    {
       return menu.getMenuName()+"<font color=\"#888\">&nbsp;&nbsp;&nbsp;" + menu.getPerms() + "</font>";
    }

    /** 节点ID */
    private Long id;

    /** 节点标题 */
    private String title;

    /** 是否勾选 */
    private boolean checked = false;

    /** 是否展开 */
    private boolean spread = false;

    private List<LayTree> children;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public List<LayTree> getChildren() {
        return children;
    }

    public void setChildren(List<LayTree> children) {
        this.children = children;
    }





}
