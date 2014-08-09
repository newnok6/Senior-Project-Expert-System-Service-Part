package drugExpertSystem.substance.Entity.SubstanceFunction;

/**
 * Created by Panupak on 7/20/2014.
 */
public class Bider extends CompoundFunction {
    String type;

    public Bider(long id,String type) {
        super.id =id;
        this.type = type;
    }



    @Override
    public void setId(long id) {
        super.setId(id);
    }

    @Override
    public long getId() {
        return super.getId();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
