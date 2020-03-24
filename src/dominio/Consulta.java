package dominio;

public class Consulta {
    
    private String select, from, where, group, order, limit;

    public String getSelect() {
        if(select.equals("")) return "";
        else return "SELECT " + select;
    }

    public void setSelect(String select) {
        this.select = select;
    }

    public String getFrom() {
        if(from.equals("")) return "";
        else return "FROM " + from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getWhere() {
        if(where.equals("")) return "";
        else return "WHERE " + where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getGroup() {
        if(group.equals("")) return "";
        else return "GROUP BY " + group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getOrder() {
        if(order.equals("")) return "";
        else return "ORDER BY " + order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getLimit() {
        if(limit.equals("")) return "";
        else return "LIMIT " + limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }
    
    @Override
    public String toString() {
        return getSelect() + " " + getFrom() + " " + getWhere() + " " + getGroup() + " " + getOrder() + " " + getLimit() + ";";
    }
 
    
}