package org.made.neohabitat.mods;

import org.elkoserver.foundation.json.JSONMethod;
import org.elkoserver.foundation.json.OptInteger;
import org.elkoserver.json.EncodeControl;
import org.elkoserver.json.JSONLiteral;
import org.made.neohabitat.Openable;

/**
 * Habitat Display Case Mod
 *
 * A Display Case is a large container that can be open/closed and [un]locked,
 * but is not portable, like the Box.
 *
 * @author steve
 */
public class Display_case extends Openable {

    public int HabitatClass() {
        return CLASS_DISPLAY_CASE;
    }

    public String HabitatModName() {
        return "Display_case";
    }

    public int capacity() {
        return 5;
    }

    public int pc_state_bytes() {
        return 3;
    };

    public boolean known() {
        return true;
    }

    public boolean opaque_container() {
        return true;
    }

    public boolean filler() {
        return false;
    }

    @JSONMethod({ "style", "x", "y", "orientation", "gr_state", "open_flags", "key_lo", "key_hi" })
    public Display_case(OptInteger style, OptInteger x, OptInteger y, OptInteger orientation, OptInteger gr_state,
                 OptInteger open_flags, OptInteger key_lo, OptInteger key_hi) {
        super(style, x, y, orientation, gr_state, open_flags, key_lo, key_hi);
    }

    @Override
    public JSONLiteral encode(EncodeControl control) {
        JSONLiteral result = super.encodeOpenable(new JSONLiteral(HabitatModName(), control));
        result.finish();
        return result;
    }

}
