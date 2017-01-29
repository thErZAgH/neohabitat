package org.made.neohabitat.mods;

import org.elkoserver.foundation.json.JSONMethod;
import org.elkoserver.foundation.json.OptInteger;
import org.elkoserver.json.EncodeControl;
import org.elkoserver.json.JSONLiteral;
import org.made.neohabitat.HabitatMod;

/**
 * Habitat Street Mod (attached to an Elko Item.)
 * 
 * Streets are scenic on the ground and you can walk on then.
 * 
 * @author randy
 *
 */
public class Street extends HabitatMod {
    
    public int HabitatClass() {
        return CLASS_STREET;
    }
    
    public String HabitatModName() {
        return "Street";
    }
    
    public int capacity() {
        return 0;
    }
    
    public int pc_state_bytes() {
        return 2;
    };
    
    public boolean known() {
        return true;
    }
    
    public boolean opaque_container() {
        return false;
    }
    
    public boolean filler() {
        return false;
    }
    
    public int width;  
    public int height;
        
    @JSONMethod({ "style", "x", "y", "orientation", "gr_state",  "width", "height" })
    public Street(OptInteger style, OptInteger x, OptInteger y, OptInteger orientation, OptInteger gr_state,
            OptInteger width, OptInteger height) {
        super(style, x, y, orientation, gr_state);
        this.width  = width.value(0);
        this.height = height.value(0);
    }
    
    @Override
    public JSONLiteral encode(EncodeControl control) {
        JSONLiteral result = super.encodeCommon(new JSONLiteral(HabitatModName(), control));
        result.addParameter("width", width);
        result.addParameter("height", height);
        result.finish();
        return result;
    }    
}