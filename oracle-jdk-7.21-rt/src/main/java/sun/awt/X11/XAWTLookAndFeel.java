/*     */ package sun.awt.X11;
/*     */ 
/*     */ import com.sun.java.swing.plaf.motif.MotifBorders.BevelBorder;
/*     */ import com.sun.java.swing.plaf.motif.MotifBorders.FocusBorder;
/*     */ import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
/*     */ import java.awt.Color;
/*     */ import java.awt.SystemColor;
/*     */ import javax.swing.UIDefaults;
/*     */ import javax.swing.UIDefaults.LazyInputMap;
/*     */ import javax.swing.plaf.BorderUIResource.CompoundBorderUIResource;
/*     */ import javax.swing.plaf.ColorUIResource;
/*     */ import javax.swing.plaf.FontUIResource;
/*     */ import javax.swing.plaf.InsetsUIResource;
/*     */ import javax.swing.plaf.basic.BasicBorders.MarginBorder;
/*     */ 
/*     */ class XAWTLookAndFeel extends MotifLookAndFeel
/*     */ {
/*     */   protected void initSystemColorDefaults(UIDefaults paramUIDefaults)
/*     */   {
/*  52 */     String[] arrayOfString = { "desktop", "#005C5C", "activeCaption", "#000080", "activeCaptionText", "#FFFFFF", "activeCaptionBorder", "#B24D7A", "inactiveCaption", "#AEB2C3", "inactiveCaptionText", "#000000", "inactiveCaptionBorder", "#AEB2C3", "window", "#AEB2C3", "windowBorder", "#AEB2C3", "windowText", "#000000", "menu", "#AEB2C3", "menuText", "#000000", "text", "#FFF7E9", "textText", "#000000", "textHighlight", "#000000", "textHighlightText", "#FFF7E9", "textInactiveText", "#808080", "control", "#AEB2C3", "controlText", "#000000", "controlHighlight", "#DCDEE5", "controlLtHighlight", "#DCDEE5", "controlShadow", "#63656F", "controlLightShadow", "#9397A5", "controlDkShadow", "#000000", "scrollbar", "#AEB2C3", "info", "#FFF7E9", "infoText", "#000000" };
/*     */ 
/*  82 */     loadSystemColors(paramUIDefaults, arrayOfString, true);
/*     */   }
/*     */ 
/*     */   protected void initComponentDefaults(UIDefaults paramUIDefaults) {
/*  86 */     super.initComponentDefaults(paramUIDefaults);
/*     */ 
/*  88 */     FontUIResource localFontUIResource1 = new FontUIResource("Dialog", 0, 12);
/*     */ 
/*  90 */     FontUIResource localFontUIResource2 = new FontUIResource("SansSerif", 0, 12);
/*     */ 
/*  92 */     FontUIResource localFontUIResource3 = new FontUIResource("Monospaced", 0, 12);
/*     */ 
/*  94 */     ColorUIResource localColorUIResource1 = new ColorUIResource(Color.red);
/*  95 */     ColorUIResource localColorUIResource2 = new ColorUIResource(Color.black);
/*  96 */     ColorUIResource localColorUIResource3 = new ColorUIResource(Color.white);
/*  97 */     ColorUIResource localColorUIResource4 = new ColorUIResource(Color.lightGray);
/*  98 */     ColorUIResource localColorUIResource5 = new ColorUIResource(SystemColor.controlDkShadow);
/*     */ 
/* 100 */     Color localColor1 = paramUIDefaults.getColor("control");
/* 101 */     Color[] arrayOfColor = XComponentPeer.getSystemColors();
/* 102 */     Color localColor2 = arrayOfColor[0];
/* 103 */     Color localColor3 = new Color(MotifColorUtilities.calculateSelectFromBackground(localColor2.getRed(), localColor2.getGreen(), localColor2.getBlue()));
/* 104 */     MotifBorders.BevelBorder localBevelBorder1 = new MotifBorders.BevelBorder(false, paramUIDefaults.getColor("controlShadow"), paramUIDefaults.getColor("controlLtHighlight"));
/*     */ 
/* 108 */     MotifBorders.BevelBorder localBevelBorder2 = new MotifBorders.BevelBorder(true, paramUIDefaults.getColor("controlShadow"), paramUIDefaults.getColor("controlLtHighlight"));
/*     */ 
/* 112 */     BasicBorders.MarginBorder localMarginBorder = new BasicBorders.MarginBorder();
/*     */ 
/* 114 */     MotifBorders.FocusBorder localFocusBorder = new MotifBorders.FocusBorder(paramUIDefaults.getColor("control"), paramUIDefaults.getColor("activeCaptionBorder"));
/*     */ 
/* 119 */     BorderUIResource.CompoundBorderUIResource localCompoundBorderUIResource1 = new BorderUIResource.CompoundBorderUIResource(localFocusBorder, localBevelBorder1);
/*     */ 
/* 123 */     BorderUIResource.CompoundBorderUIResource localCompoundBorderUIResource2 = new BorderUIResource.CompoundBorderUIResource(localCompoundBorderUIResource1, localMarginBorder);
/*     */ 
/* 129 */     UIDefaults.LazyInputMap localLazyInputMap1 = new UIDefaults.LazyInputMap(new Object[] { "COPY", "copy-to-clipboard", "PASTE", "paste-from-clipboard", "CUT", "cut-to-clipboard", "control C", "copy-to-clipboard", "control V", "paste-from-clipboard", "control X", "cut-to-clipboard", "control INSERT", "copy-to-clipboard", "shift INSERT", "paste-from-clipboard", "shift DELETE", "cut-to-clipboard", "control F", "caret-forward", "control B", "caret-backward", "control D", "delete-next", "typed \b", "delete-previous", "DELETE", "delete-next", "RIGHT", "caret-forward", "LEFT", "caret-backward", "KP_RIGHT", "caret-forward", "KP_LEFT", "caret-backward", "shift LEFT", "selection-backward", "shift RIGHT", "selection-forward", "control LEFT", "caret-previous-word", "control RIGHT", "caret-next-word", "control shift LEFT", "selection-previous-word", "control shift RIGHT", "selection-next-word", "control SLASH", "select-all", "HOME", "caret-begin-line", "END", "caret-end-line", "shift HOME", "selection-begin-line", "shift END", "selection-end-line", "control BACK_SLASH", "unselect", "ENTER", "notify-field-accept", "control shift O", "toggle-componentOrientation" });
/*     */ 
/* 164 */     UIDefaults.LazyInputMap localLazyInputMap2 = new UIDefaults.LazyInputMap(new Object[] { "COPY", "copy-to-clipboard", "PASTE", "paste-from-clipboard", "CUT", "cut-to-clipboard", "control C", "copy-to-clipboard", "control V", "paste-from-clipboard", "control X", "cut-to-clipboard", "control INSERT", "copy-to-clipboard", "shift INSERT", "paste-from-clipboard", "shift DELETE", "cut-to-clipboard", "control F", "caret-forward", "control B", "caret-backward", "control D", "delete-next", "typed \b", "delete-previous", "DELETE", "delete-next", "RIGHT", "caret-forward", "LEFT", "caret-backward", "KP_RIGHT", "caret-forward", "KP_LEFT", "caret-backward", "shift LEFT", "selection-backward", "shift RIGHT", "selection-forward", "control LEFT", "caret-begin-line", "control RIGHT", "caret-end-line", "control shift LEFT", "selection-begin-line", "control shift RIGHT", "selection-end-line", "control SLASH", "select-all", "HOME", "caret-begin-line", "END", "caret-end-line", "shift HOME", "selection-begin-line", "shift END", "selection-end-line", "control BACK_SLASH", "unselect", "ENTER", "notify-field-accept", "control shift O", "toggle-componentOrientation" });
/*     */ 
/* 199 */     UIDefaults.LazyInputMap localLazyInputMap3 = new UIDefaults.LazyInputMap(new Object[] { "COPY", "copy-to-clipboard", "PASTE", "paste-from-clipboard", "CUT", "cut-to-clipboard", "control C", "copy-to-clipboard", "control V", "paste-from-clipboard", "control X", "cut-to-clipboard", "control INSERT", "copy-to-clipboard", "shift INSERT", "paste-from-clipboard", "shift DELETE", "cut-to-clipboard", "control F", "caret-forward", "control B", "caret-backward", "control D", "delete-next", "typed \b", "delete-previous", "DELETE", "delete-next", "RIGHT", "caret-forward", "LEFT", "caret-backward", "KP_RIGHT", "caret-forward", "KP_LEFT", "caret-backward", "shift LEFT", "selection-backward", "shift RIGHT", "selection-forward", "control LEFT", "caret-previous-word", "control RIGHT", "caret-next-word", "control shift LEFT", "selection-previous-word", "control shift RIGHT", "selection-next-word", "control SLASH", "select-all", "HOME", "caret-begin-line", "END", "caret-end-line", "shift HOME", "selection-begin-line", "shift END", "selection-end-line", "control N", "caret-down", "control P", "caret-up", "UP", "caret-up", "DOWN", "caret-down", "KP_UP", "caret-up", "KP_DOWN", "caret-down", "PAGE_UP", "page-up", "PAGE_DOWN", "page-down", "shift PAGE_UP", "selection-page-up", "shift PAGE_DOWN", "selection-page-down", "ctrl shift PAGE_UP", "selection-page-left", "ctrl shift PAGE_DOWN", "selection-page-right", "shift UP", "selection-up", "shift DOWN", "selection-down", "shift KP_UP", "selection-up", "shift KP_DOWN", "selection-down", "ENTER", "insert-break", "TAB", "insert-tab", "control BACK_SLASH", "unselect", "control HOME", "caret-begin", "control END", "caret-end", "control shift HOME", "selection-begin", "control shift END", "selection-end", "control T", "next-link-action", "control shift T", "previous-link-action", "control SPACE", "activate-link-action", "control shift O", "toggle-componentOrientation" });
/*     */ 
/* 259 */     InsetsUIResource localInsetsUIResource = new InsetsUIResource(0, 0, 0, 0);
/*     */ 
/* 261 */     Object[] arrayOfObject = { "ScrollBar.background", localColor2, "ScrollBar.foreground", paramUIDefaults.get("control"), "ScrollBar.track", localColor3, "ScrollBar.trackHighlight", localColor3, "ScrollBar.thumb", localColor2, "ScrollBar.thumbHighlight", paramUIDefaults.get("controlHighlight"), "ScrollBar.thumbDarkShadow", paramUIDefaults.get("controlDkShadow"), "ScrollBar.thumbShadow", paramUIDefaults.get("controlShadow"), "ScrollBar.border", localBevelBorder1, "ScrollBar.allowsAbsolutePositioning", Boolean.TRUE, "ScrollBar.defaultWidth", Integer.valueOf(17), "ScrollBar.focusInputMap", new UIDefaults.LazyInputMap(new Object[] { "RIGHT", "positiveUnitIncrement", "KP_RIGHT", "positiveUnitIncrement", "DOWN", "positiveUnitIncrement", "KP_DOWN", "positiveUnitIncrement", "PAGE_DOWN", "positiveBlockIncrement", "ctrl PAGE_DOWN", "positiveBlockIncrement", "LEFT", "negativeUnitIncrement", "KP_LEFT", "negativeUnitIncrement", "UP", "negativeUnitIncrement", "KP_UP", "negativeUnitIncrement", "PAGE_UP", "negativeBlockIncrement", "ctrl PAGE_UP", "negativeBlockIncrement", "HOME", "minScroll", "END", "maxScroll" }), "ScrollPane.font", localFontUIResource1, "ScrollPane.background", localColor2, "ScrollPane.foreground", paramUIDefaults.get("controlText"), "ScrollPane.border", null, "ScrollPane.viewportBorder", localBevelBorder1, "ScrollPane.ancestorInputMap", new UIDefaults.LazyInputMap(new Object[] { "RIGHT", "unitScrollRight", "KP_RIGHT", "unitScrollRight", "DOWN", "unitScrollDown", "KP_DOWN", "unitScrollDown", "LEFT", "unitScrollLeft", "KP_LEFT", "unitScrollLeft", "UP", "unitScrollUp", "KP_UP", "unitScrollUp", "PAGE_UP", "scrollUp", "PAGE_DOWN", "scrollDown", "ctrl PAGE_UP", "scrollLeft", "ctrl PAGE_DOWN", "scrollRight", "ctrl HOME", "scrollHome", "ctrl END", "scrollEnd" }), "FormattedTextField.focusInputMap", new UIDefaults.LazyInputMap(new Object[] { "ctrl C", "copy-to-clipboard", "ctrl V", "paste-from-clipboard", "ctrl X", "cut-to-clipboard", "COPY", "copy-to-clipboard", "PASTE", "paste-from-clipboard", "CUT", "cut-to-clipboard", "shift LEFT", "selection-backward", "shift KP_LEFT", "selection-backward", "shift RIGHT", "selection-forward", "shift KP_RIGHT", "selection-forward", "ctrl LEFT", "caret-previous-word", "ctrl KP_LEFT", "caret-previous-word", "ctrl RIGHT", "caret-next-word", "ctrl KP_RIGHT", "caret-next-word", "ctrl shift LEFT", "selection-previous-word", "ctrl shift KP_LEFT", "selection-previous-word", "ctrl shift RIGHT", "selection-next-word", "ctrl shift KP_RIGHT", "selection-next-word", "ctrl A", "select-all", "HOME", "caret-begin-line", "END", "caret-end-line", "shift HOME", "selection-begin-line", "shift END", "selection-end-line", "typed \b", "delete-previous", "DELETE", "delete-next", "RIGHT", "caret-forward", "LEFT", "caret-backward", "KP_RIGHT", "caret-forward", "KP_LEFT", "caret-backward", "ENTER", "notify-field-accept", "ctrl BACK_SLASH", "unselect", "control shift O", "toggle-componentOrientation", "ESCAPE", "reset-field-edit", "UP", "increment", "KP_UP", "increment", "DOWN", "decrement", "KP_DOWN", "decrement" }), "TextField.caretForeground", localColorUIResource2, "TextField.caretBlinkRate", Integer.valueOf(500), "TextField.inactiveForeground", paramUIDefaults.get("textInactiveText"), "TextField.selectionBackground", paramUIDefaults.get("textHighlight"), "TextField.selectionForeground", paramUIDefaults.get("textHighlightText"), "TextField.background", paramUIDefaults.get("window"), "TextField.foreground", paramUIDefaults.get("textText"), "TextField.font", localFontUIResource2, "TextField.border", localCompoundBorderUIResource2, "TextField.focusInputMap", localLazyInputMap1, "PasswordField.caretForeground", localColorUIResource2, "PasswordField.caretBlinkRate", Integer.valueOf(500), "PasswordField.inactiveForeground", paramUIDefaults.get("textInactiveText"), "PasswordField.selectionBackground", paramUIDefaults.get("textHighlight"), "PasswordField.selectionForeground", paramUIDefaults.get("textHighlightText"), "PasswordField.background", paramUIDefaults.get("window"), "PasswordField.foreground", paramUIDefaults.get("textText"), "PasswordField.font", localFontUIResource2, "PasswordField.border", localCompoundBorderUIResource2, "PasswordField.focusInputMap", localLazyInputMap2, "TextArea.caretForeground", localColorUIResource2, "TextArea.caretBlinkRate", Integer.valueOf(500), "TextArea.inactiveForeground", paramUIDefaults.get("textInactiveText"), "TextArea.selectionBackground", paramUIDefaults.get("textHighlight"), "TextArea.selectionForeground", paramUIDefaults.get("textHighlightText"), "TextArea.background", paramUIDefaults.get("window"), "TextArea.foreground", paramUIDefaults.get("textText"), "TextArea.font", localFontUIResource3, "TextArea.border", localMarginBorder, "TextArea.focusInputMap", localLazyInputMap3 };
/*     */ 
/* 390 */     paramUIDefaults.putDefaults(arrayOfObject);
/*     */   }
/*     */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     sun.awt.X11.XAWTLookAndFeel
 * JD-Core Version:    0.6.2
 */