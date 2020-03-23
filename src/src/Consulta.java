package src;

public class Consulta {
    
    private String select, from, where, group, order, limit;
    
    private Consulta() {
    }
    
    Consulta(ConsultaBuilder builder) {
        this.select = builder.getSelect();
        this.from = builder.getFrom();
        this.where = builder.getWhere();
        this.group = builder.getGroup();
        this.order = builder.getOrder();
        this.limit = builder.getLimit();
    }

    @Override
    public String toString() {
        return select + " " + from + " " + where + " " + group + " " + order + " " + limit + ";";
    }
}