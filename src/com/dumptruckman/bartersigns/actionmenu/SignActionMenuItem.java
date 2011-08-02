package com.dumptruckman.bartersigns.actionmenu;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * @author dumptruckman
 */
public abstract class SignActionMenuItem extends ActionMenuItem {

    protected List<String> lines;
    protected Player player;

    /**
     * ActionMenuItem designed specifically for the SignActionMenu.  It contains 4 lines of text.
     *
     * @param lines List of text lines.
     */
    public SignActionMenuItem(List<String> lines) {
        this.lines = lines;
    }

    /**
     * Sets the player for this sign's menu interaction.
     * @param player Player interacting with the sign menu.
     */
    protected void setInteractingPlayer(Player player) {
        this.player = player;
    }

    /**
     * Get the lines of text on this sign.
     * @return Lines of text on the sign.
     */
    public List<String> getLines() {
        return lines;
    }

    /**
     * When the sign is cycled it sets the player causing the cycle event as the player interacting with the sign.
     * @param sender Whoever caused the cycle event.  Could be null.
     */
    @Override
    protected void onCycle(CommandSender sender) {
        setInteractingPlayer((sender instanceof Player ? (Player) sender : null));
    }

    /**
     * When the menu item is selected it sets the player causing the cycle event as the player interacting with the sign.
     * @param sender Whoever caused the selection event.  Could be null.
     */
    @Override
    protected void onSelect(CommandSender sender) {
        setInteractingPlayer((sender instanceof Player ? (Player) sender : null));
    }

    /**
     * Returns a single line of text at specified index.
     * @param index Index of text line ot retrieve.
     * @return Line of text at index.
     */
    public String getLine(int index) {
        return lines.get(index);
    }

    /**
     * Sets the text for this menu item.
     * @param lines List of text.
     */
    public void setLines(List<String> lines) {
        this.lines = lines;
    }

    /**
     * Sets a specific line of this menu item's text.
     * @param index Index of line.
     * @param line Text for line.
     * @throws IndexOutOfBoundsException
     */
    public void setLine(int index, String line) throws IndexOutOfBoundsException {
        if (index > 3) {
            throw new IndexOutOfBoundsException("Only 4 lines allowed");
        }
        lines.set(index, line);
    }
}
