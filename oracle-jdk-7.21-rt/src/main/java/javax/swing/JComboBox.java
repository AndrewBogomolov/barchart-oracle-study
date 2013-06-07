/*      */ package javax.swing;
/*      */ 
/*      */ import java.awt.AWTEvent;
/*      */ import java.awt.Component;
/*      */ import java.awt.EventQueue;
/*      */ import java.awt.IllegalComponentStateException;
/*      */ import java.awt.ItemSelectable;
/*      */ import java.awt.event.ActionEvent;
/*      */ import java.awt.event.ActionListener;
/*      */ import java.awt.event.InputEvent;
/*      */ import java.awt.event.ItemEvent;
/*      */ import java.awt.event.ItemListener;
/*      */ import java.awt.event.KeyEvent;
/*      */ import java.beans.PropertyChangeEvent;
/*      */ import java.beans.PropertyChangeListener;
/*      */ import java.beans.Transient;
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectOutputStream;
/*      */ import java.io.Serializable;
/*      */ import java.util.Locale;
/*      */ import java.util.Vector;
/*      */ import javax.accessibility.Accessible;
/*      */ import javax.accessibility.AccessibleAction;
/*      */ import javax.accessibility.AccessibleComponent;
/*      */ import javax.accessibility.AccessibleContext;
/*      */ import javax.accessibility.AccessibleEditableText;
/*      */ import javax.accessibility.AccessibleIcon;
/*      */ import javax.accessibility.AccessibleRelationSet;
/*      */ import javax.accessibility.AccessibleRole;
/*      */ import javax.accessibility.AccessibleSelection;
/*      */ import javax.accessibility.AccessibleState;
/*      */ import javax.accessibility.AccessibleStateSet;
/*      */ import javax.accessibility.AccessibleTable;
/*      */ import javax.accessibility.AccessibleText;
/*      */ import javax.accessibility.AccessibleValue;
/*      */ import javax.swing.event.AncestorEvent;
/*      */ import javax.swing.event.AncestorListener;
/*      */ import javax.swing.event.EventListenerList;
/*      */ import javax.swing.event.ListDataEvent;
/*      */ import javax.swing.event.ListDataListener;
/*      */ import javax.swing.event.ListSelectionEvent;
/*      */ import javax.swing.event.ListSelectionListener;
/*      */ import javax.swing.event.PopupMenuEvent;
/*      */ import javax.swing.event.PopupMenuListener;
/*      */ import javax.swing.plaf.ComboBoxUI;
/*      */ import javax.swing.plaf.ComponentUI;
/*      */ import javax.swing.plaf.basic.ComboPopup;
/*      */ 
/*      */ public class JComboBox<E> extends JComponent
/*      */   implements ItemSelectable, ListDataListener, ActionListener, Accessible
/*      */ {
/*      */   private static final String uiClassID = "ComboBoxUI";
/*      */   protected ComboBoxModel<E> dataModel;
/*      */   protected ListCellRenderer<? super E> renderer;
/*      */   protected ComboBoxEditor editor;
/*  120 */   protected int maximumRowCount = 8;
/*      */ 
/*  129 */   protected boolean isEditable = false;
/*      */ 
/*  137 */   protected KeySelectionManager keySelectionManager = null;
/*      */ 
/*  145 */   protected String actionCommand = "comboBoxChanged";
/*      */ 
/*  153 */   protected boolean lightWeightPopupEnabled = JPopupMenu.getDefaultLightWeightPopupEnabled();
/*      */ 
/*  159 */   protected Object selectedItemReminder = null;
/*      */   private E prototypeDisplayValue;
/*  164 */   private boolean firingActionEvent = false;
/*      */ 
/*  167 */   private boolean selectingItem = false;
/*      */   private Action action;
/*      */   private PropertyChangeListener actionPropertyChangeListener;
/*      */ 
/*      */   public JComboBox(ComboBoxModel<E> paramComboBoxModel)
/*      */   {
/*  182 */     setModel(paramComboBoxModel);
/*  183 */     init();
/*      */   }
/*      */ 
/*      */   public JComboBox(E[] paramArrayOfE)
/*      */   {
/*  196 */     setModel(new DefaultComboBoxModel(paramArrayOfE));
/*  197 */     init();
/*      */   }
/*      */ 
/*      */   public JComboBox(Vector<E> paramVector)
/*      */   {
/*  210 */     setModel(new DefaultComboBoxModel(paramVector));
/*  211 */     init();
/*      */   }
/*      */ 
/*      */   public JComboBox()
/*      */   {
/*  224 */     setModel(new DefaultComboBoxModel());
/*  225 */     init();
/*      */   }
/*      */ 
/*      */   private void init() {
/*  229 */     installAncestorListener();
/*  230 */     setUIProperty("opaque", Boolean.valueOf(true));
/*  231 */     updateUI();
/*      */   }
/*      */ 
/*      */   protected void installAncestorListener() {
/*  235 */     addAncestorListener(new AncestorListener() {
/*  236 */       public void ancestorAdded(AncestorEvent paramAnonymousAncestorEvent) { JComboBox.this.hidePopup(); } 
/*  237 */       public void ancestorRemoved(AncestorEvent paramAnonymousAncestorEvent) { JComboBox.this.hidePopup(); } 
/*      */       public void ancestorMoved(AncestorEvent paramAnonymousAncestorEvent) {
/*  239 */         if (paramAnonymousAncestorEvent.getSource() != JComboBox.this)
/*  240 */           JComboBox.this.hidePopup();
/*      */       }
/*      */     });
/*      */   }
/*      */ 
/*      */   public void setUI(ComboBoxUI paramComboBoxUI)
/*      */   {
/*  257 */     super.setUI(paramComboBoxUI);
/*      */   }
/*      */ 
/*      */   public void updateUI()
/*      */   {
/*  266 */     setUI((ComboBoxUI)UIManager.getUI(this));
/*      */ 
/*  268 */     ListCellRenderer localListCellRenderer = getRenderer();
/*  269 */     if ((localListCellRenderer instanceof Component))
/*  270 */       SwingUtilities.updateComponentTreeUI((Component)localListCellRenderer);
/*      */   }
/*      */ 
/*      */   public String getUIClassID()
/*      */   {
/*  283 */     return "ComboBoxUI";
/*      */   }
/*      */ 
/*      */   public ComboBoxUI getUI()
/*      */   {
/*  293 */     return (ComboBoxUI)this.ui;
/*      */   }
/*      */ 
/*      */   public void setModel(ComboBoxModel<E> paramComboBoxModel)
/*      */   {
/*  308 */     ComboBoxModel localComboBoxModel = this.dataModel;
/*  309 */     if (localComboBoxModel != null) {
/*  310 */       localComboBoxModel.removeListDataListener(this);
/*      */     }
/*  312 */     this.dataModel = paramComboBoxModel;
/*  313 */     this.dataModel.addListDataListener(this);
/*      */ 
/*  316 */     this.selectedItemReminder = this.dataModel.getSelectedItem();
/*      */ 
/*  318 */     firePropertyChange("model", localComboBoxModel, this.dataModel);
/*      */   }
/*      */ 
/*      */   public ComboBoxModel<E> getModel()
/*      */   {
/*  328 */     return this.dataModel;
/*      */   }
/*      */ 
/*      */   public void setLightWeightPopupEnabled(boolean paramBoolean)
/*      */   {
/*  366 */     boolean bool = this.lightWeightPopupEnabled;
/*  367 */     this.lightWeightPopupEnabled = paramBoolean;
/*  368 */     firePropertyChange("lightWeightPopupEnabled", bool, this.lightWeightPopupEnabled);
/*      */   }
/*      */ 
/*      */   public boolean isLightWeightPopupEnabled()
/*      */   {
/*  380 */     return this.lightWeightPopupEnabled;
/*      */   }
/*      */ 
/*      */   public void setEditable(boolean paramBoolean)
/*      */   {
/*  401 */     boolean bool = this.isEditable;
/*  402 */     this.isEditable = paramBoolean;
/*  403 */     firePropertyChange("editable", bool, this.isEditable);
/*      */   }
/*      */ 
/*      */   public boolean isEditable()
/*      */   {
/*  413 */     return this.isEditable;
/*      */   }
/*      */ 
/*      */   public void setMaximumRowCount(int paramInt)
/*      */   {
/*  429 */     int i = this.maximumRowCount;
/*  430 */     this.maximumRowCount = paramInt;
/*  431 */     firePropertyChange("maximumRowCount", i, this.maximumRowCount);
/*      */   }
/*      */ 
/*      */   public int getMaximumRowCount()
/*      */   {
/*  442 */     return this.maximumRowCount;
/*      */   }
/*      */ 
/*      */   public void setRenderer(ListCellRenderer<? super E> paramListCellRenderer)
/*      */   {
/*  467 */     ListCellRenderer localListCellRenderer = this.renderer;
/*  468 */     this.renderer = paramListCellRenderer;
/*  469 */     firePropertyChange("renderer", localListCellRenderer, this.renderer);
/*  470 */     invalidate();
/*      */   }
/*      */ 
/*      */   public ListCellRenderer<? super E> getRenderer()
/*      */   {
/*  481 */     return this.renderer;
/*      */   }
/*      */ 
/*      */   public void setEditor(ComboBoxEditor paramComboBoxEditor)
/*      */   {
/*  499 */     ComboBoxEditor localComboBoxEditor = this.editor;
/*      */ 
/*  501 */     if (this.editor != null) {
/*  502 */       this.editor.removeActionListener(this);
/*      */     }
/*  504 */     this.editor = paramComboBoxEditor;
/*  505 */     if (this.editor != null) {
/*  506 */       this.editor.addActionListener(this);
/*      */     }
/*  508 */     firePropertyChange("editor", localComboBoxEditor, this.editor);
/*      */   }
/*      */ 
/*      */   public ComboBoxEditor getEditor()
/*      */   {
/*  518 */     return this.editor;
/*      */   }
/*      */ 
/*      */   public void setSelectedItem(Object paramObject)
/*      */   {
/*  554 */     Object localObject1 = this.selectedItemReminder;
/*  555 */     Object localObject2 = paramObject;
/*  556 */     if ((localObject1 == null) || (!localObject1.equals(paramObject)))
/*      */     {
/*  558 */       if ((paramObject != null) && (!isEditable()))
/*      */       {
/*  561 */         int i = 0;
/*  562 */         for (int j = 0; j < this.dataModel.getSize(); j++) {
/*  563 */           Object localObject3 = this.dataModel.getElementAt(j);
/*  564 */           if (paramObject.equals(localObject3)) {
/*  565 */             i = 1;
/*  566 */             localObject2 = localObject3;
/*  567 */             break;
/*      */           }
/*      */         }
/*  570 */         if (i == 0) {
/*  571 */           return;
/*      */         }
/*      */ 
/*      */       }
/*      */ 
/*  577 */       this.selectingItem = true;
/*  578 */       this.dataModel.setSelectedItem(localObject2);
/*  579 */       this.selectingItem = false;
/*      */ 
/*  581 */       if (this.selectedItemReminder != this.dataModel.getSelectedItem())
/*      */       {
/*  585 */         selectedItemChanged();
/*      */       }
/*      */     }
/*  588 */     fireActionEvent();
/*      */   }
/*      */ 
/*      */   public Object getSelectedItem()
/*      */   {
/*  602 */     return this.dataModel.getSelectedItem();
/*      */   }
/*      */ 
/*      */   public void setSelectedIndex(int paramInt)
/*      */   {
/*  617 */     int i = this.dataModel.getSize();
/*      */ 
/*  619 */     if (paramInt == -1) {
/*  620 */       setSelectedItem(null); } else {
/*  621 */       if ((paramInt < -1) || (paramInt >= i)) {
/*  622 */         throw new IllegalArgumentException("setSelectedIndex: " + paramInt + " out of bounds");
/*      */       }
/*  624 */       setSelectedItem(this.dataModel.getElementAt(paramInt));
/*      */     }
/*      */   }
/*      */ 
/*      */   @Transient
/*      */   public int getSelectedIndex()
/*      */   {
/*  643 */     Object localObject1 = this.dataModel.getSelectedItem();
/*      */ 
/*  647 */     int i = 0; for (int j = this.dataModel.getSize(); i < j; i++) {
/*  648 */       Object localObject2 = this.dataModel.getElementAt(i);
/*  649 */       if ((localObject2 != null) && (localObject2.equals(localObject1)))
/*  650 */         return i;
/*      */     }
/*  652 */     return -1;
/*      */   }
/*      */ 
/*      */   public E getPrototypeDisplayValue()
/*      */   {
/*  664 */     return this.prototypeDisplayValue;
/*      */   }
/*      */ 
/*      */   public void setPrototypeDisplayValue(E paramE)
/*      */   {
/*  689 */     Object localObject = this.prototypeDisplayValue;
/*  690 */     this.prototypeDisplayValue = paramE;
/*  691 */     firePropertyChange("prototypeDisplayValue", localObject, paramE);
/*      */   }
/*      */ 
/*      */   public void addItem(E paramE)
/*      */   {
/*  717 */     checkMutableComboBoxModel();
/*  718 */     ((MutableComboBoxModel)this.dataModel).addElement(paramE);
/*      */   }
/*      */ 
/*      */   public void insertItemAt(E paramE, int paramInt)
/*      */   {
/*  732 */     checkMutableComboBoxModel();
/*  733 */     ((MutableComboBoxModel)this.dataModel).insertElementAt(paramE, paramInt);
/*      */   }
/*      */ 
/*      */   public void removeItem(Object paramObject)
/*      */   {
/*  745 */     checkMutableComboBoxModel();
/*  746 */     ((MutableComboBoxModel)this.dataModel).removeElement(paramObject);
/*      */   }
/*      */ 
/*      */   public void removeItemAt(int paramInt)
/*      */   {
/*  760 */     checkMutableComboBoxModel();
/*  761 */     ((MutableComboBoxModel)this.dataModel).removeElementAt(paramInt);
/*      */   }
/*      */ 
/*      */   public void removeAllItems()
/*      */   {
/*  768 */     checkMutableComboBoxModel();
/*  769 */     MutableComboBoxModel localMutableComboBoxModel = (MutableComboBoxModel)this.dataModel;
/*  770 */     int i = localMutableComboBoxModel.getSize();
/*      */ 
/*  772 */     if ((localMutableComboBoxModel instanceof DefaultComboBoxModel)) {
/*  773 */       ((DefaultComboBoxModel)localMutableComboBoxModel).removeAllElements();
/*      */     }
/*      */     else {
/*  776 */       for (int j = 0; j < i; j++) {
/*  777 */         Object localObject = localMutableComboBoxModel.getElementAt(0);
/*  778 */         localMutableComboBoxModel.removeElement(localObject);
/*      */       }
/*      */     }
/*  781 */     this.selectedItemReminder = null;
/*  782 */     if (isEditable())
/*  783 */       this.editor.setItem(null);
/*      */   }
/*      */ 
/*      */   void checkMutableComboBoxModel()
/*      */   {
/*  794 */     if (!(this.dataModel instanceof MutableComboBoxModel))
/*  795 */       throw new RuntimeException("Cannot use this method with a non-Mutable data model.");
/*      */   }
/*      */ 
/*      */   public void showPopup()
/*      */   {
/*  803 */     setPopupVisible(true);
/*      */   }
/*      */ 
/*      */   public void hidePopup()
/*      */   {
/*  811 */     setPopupVisible(false);
/*      */   }
/*      */ 
/*      */   public void setPopupVisible(boolean paramBoolean)
/*      */   {
/*  818 */     getUI().setPopupVisible(this, paramBoolean);
/*      */   }
/*      */ 
/*      */   public boolean isPopupVisible()
/*      */   {
/*  827 */     return getUI().isPopupVisible(this);
/*      */   }
/*      */ 
/*      */   public void addItemListener(ItemListener paramItemListener)
/*      */   {
/*  842 */     this.listenerList.add(ItemListener.class, paramItemListener);
/*      */   }
/*      */ 
/*      */   public void removeItemListener(ItemListener paramItemListener)
/*      */   {
/*  850 */     this.listenerList.remove(ItemListener.class, paramItemListener);
/*      */   }
/*      */ 
/*      */   public ItemListener[] getItemListeners()
/*      */   {
/*  862 */     return (ItemListener[])this.listenerList.getListeners(ItemListener.class);
/*      */   }
/*      */ 
/*      */   public void addActionListener(ActionListener paramActionListener)
/*      */   {
/*  876 */     this.listenerList.add(ActionListener.class, paramActionListener);
/*      */   }
/*      */ 
/*      */   public void removeActionListener(ActionListener paramActionListener)
/*      */   {
/*  884 */     if ((paramActionListener != null) && (getAction() == paramActionListener))
/*  885 */       setAction(null);
/*      */     else
/*  887 */       this.listenerList.remove(ActionListener.class, paramActionListener);
/*      */   }
/*      */ 
/*      */   public ActionListener[] getActionListeners()
/*      */   {
/*  900 */     return (ActionListener[])this.listenerList.getListeners(ActionListener.class);
/*      */   }
/*      */ 
/*      */   public void addPopupMenuListener(PopupMenuListener paramPopupMenuListener)
/*      */   {
/*  916 */     this.listenerList.add(PopupMenuListener.class, paramPopupMenuListener);
/*      */   }
/*      */ 
/*      */   public void removePopupMenuListener(PopupMenuListener paramPopupMenuListener)
/*      */   {
/*  927 */     this.listenerList.remove(PopupMenuListener.class, paramPopupMenuListener);
/*      */   }
/*      */ 
/*      */   public PopupMenuListener[] getPopupMenuListeners()
/*      */   {
/*  939 */     return (PopupMenuListener[])this.listenerList.getListeners(PopupMenuListener.class);
/*      */   }
/*      */ 
/*      */   public void firePopupMenuWillBecomeVisible()
/*      */   {
/*  952 */     Object[] arrayOfObject = this.listenerList.getListenerList();
/*  953 */     PopupMenuEvent localPopupMenuEvent = null;
/*  954 */     for (int i = arrayOfObject.length - 2; i >= 0; i -= 2)
/*  955 */       if (arrayOfObject[i] == PopupMenuListener.class) {
/*  956 */         if (localPopupMenuEvent == null)
/*  957 */           localPopupMenuEvent = new PopupMenuEvent(this);
/*  958 */         ((PopupMenuListener)arrayOfObject[(i + 1)]).popupMenuWillBecomeVisible(localPopupMenuEvent);
/*      */       }
/*      */   }
/*      */ 
/*      */   public void firePopupMenuWillBecomeInvisible()
/*      */   {
/*  973 */     Object[] arrayOfObject = this.listenerList.getListenerList();
/*  974 */     PopupMenuEvent localPopupMenuEvent = null;
/*  975 */     for (int i = arrayOfObject.length - 2; i >= 0; i -= 2)
/*  976 */       if (arrayOfObject[i] == PopupMenuListener.class) {
/*  977 */         if (localPopupMenuEvent == null)
/*  978 */           localPopupMenuEvent = new PopupMenuEvent(this);
/*  979 */         ((PopupMenuListener)arrayOfObject[(i + 1)]).popupMenuWillBecomeInvisible(localPopupMenuEvent);
/*      */       }
/*      */   }
/*      */ 
/*      */   public void firePopupMenuCanceled()
/*      */   {
/*  994 */     Object[] arrayOfObject = this.listenerList.getListenerList();
/*  995 */     PopupMenuEvent localPopupMenuEvent = null;
/*  996 */     for (int i = arrayOfObject.length - 2; i >= 0; i -= 2)
/*  997 */       if (arrayOfObject[i] == PopupMenuListener.class) {
/*  998 */         if (localPopupMenuEvent == null)
/*  999 */           localPopupMenuEvent = new PopupMenuEvent(this);
/* 1000 */         ((PopupMenuListener)arrayOfObject[(i + 1)]).popupMenuCanceled(localPopupMenuEvent);
/*      */       }
/*      */   }
/*      */ 
/*      */   public void setActionCommand(String paramString)
/*      */   {
/* 1015 */     this.actionCommand = paramString;
/*      */   }
/*      */ 
/*      */   public String getActionCommand()
/*      */   {
/* 1026 */     return this.actionCommand;
/*      */   }
/*      */ 
/*      */   public void setAction(Action paramAction)
/*      */   {
/* 1072 */     Action localAction = getAction();
/* 1073 */     if ((this.action == null) || (!this.action.equals(paramAction))) {
/* 1074 */       this.action = paramAction;
/* 1075 */       if (localAction != null) {
/* 1076 */         removeActionListener(localAction);
/* 1077 */         localAction.removePropertyChangeListener(this.actionPropertyChangeListener);
/* 1078 */         this.actionPropertyChangeListener = null;
/*      */       }
/* 1080 */       configurePropertiesFromAction(this.action);
/* 1081 */       if (this.action != null)
/*      */       {
/* 1083 */         if (!isListener(ActionListener.class, this.action)) {
/* 1084 */           addActionListener(this.action);
/*      */         }
/*      */ 
/* 1087 */         this.actionPropertyChangeListener = createActionPropertyChangeListener(this.action);
/* 1088 */         this.action.addPropertyChangeListener(this.actionPropertyChangeListener);
/*      */       }
/* 1090 */       firePropertyChange("action", localAction, this.action);
/*      */     }
/*      */   }
/*      */ 
/*      */   private boolean isListener(Class paramClass, ActionListener paramActionListener) {
/* 1095 */     boolean bool = false;
/* 1096 */     Object[] arrayOfObject = this.listenerList.getListenerList();
/* 1097 */     for (int i = arrayOfObject.length - 2; i >= 0; i -= 2) {
/* 1098 */       if ((arrayOfObject[i] == paramClass) && (arrayOfObject[(i + 1)] == paramActionListener)) {
/* 1099 */         bool = true;
/*      */       }
/*      */     }
/* 1102 */     return bool;
/*      */   }
/*      */ 
/*      */   public Action getAction()
/*      */   {
/* 1117 */     return this.action;
/*      */   }
/*      */ 
/*      */   protected void configurePropertiesFromAction(Action paramAction)
/*      */   {
/* 1133 */     AbstractAction.setEnabledFromAction(this, paramAction);
/* 1134 */     AbstractAction.setToolTipTextFromAction(this, paramAction);
/* 1135 */     setActionCommandFromAction(paramAction);
/*      */   }
/*      */ 
/*      */   protected PropertyChangeListener createActionPropertyChangeListener(Action paramAction)
/*      */   {
/* 1153 */     return new ComboBoxActionPropertyChangeListener(this, paramAction);
/*      */   }
/*      */ 
/*      */   protected void actionPropertyChanged(Action paramAction, String paramString)
/*      */   {
/* 1176 */     if (paramString == "ActionCommandKey")
/* 1177 */       setActionCommandFromAction(paramAction);
/* 1178 */     else if (paramString == "enabled")
/* 1179 */       AbstractAction.setEnabledFromAction(this, paramAction);
/* 1180 */     else if ("ShortDescription" == paramString)
/* 1181 */       AbstractAction.setToolTipTextFromAction(this, paramAction);
/*      */   }
/*      */ 
/*      */   private void setActionCommandFromAction(Action paramAction)
/*      */   {
/* 1186 */     setActionCommand(paramAction != null ? (String)paramAction.getValue("ActionCommandKey") : null);
/*      */   }
/*      */ 
/*      */   protected void fireItemStateChanged(ItemEvent paramItemEvent)
/*      */   {
/* 1217 */     Object[] arrayOfObject = this.listenerList.getListenerList();
/*      */ 
/* 1220 */     for (int i = arrayOfObject.length - 2; i >= 0; i -= 2)
/* 1221 */       if (arrayOfObject[i] == ItemListener.class)
/*      */       {
/* 1225 */         ((ItemListener)arrayOfObject[(i + 1)]).itemStateChanged(paramItemEvent);
/*      */       }
/*      */   }
/*      */ 
/*      */   protected void fireActionEvent()
/*      */   {
/* 1237 */     if (!this.firingActionEvent)
/*      */     {
/* 1239 */       this.firingActionEvent = true;
/* 1240 */       ActionEvent localActionEvent = null;
/*      */ 
/* 1242 */       Object[] arrayOfObject = this.listenerList.getListenerList();
/* 1243 */       long l = EventQueue.getMostRecentEventTime();
/* 1244 */       int i = 0;
/* 1245 */       AWTEvent localAWTEvent = EventQueue.getCurrentEvent();
/* 1246 */       if ((localAWTEvent instanceof InputEvent))
/* 1247 */         i = ((InputEvent)localAWTEvent).getModifiers();
/* 1248 */       else if ((localAWTEvent instanceof ActionEvent)) {
/* 1249 */         i = ((ActionEvent)localAWTEvent).getModifiers();
/*      */       }
/*      */ 
/* 1253 */       for (int j = arrayOfObject.length - 2; j >= 0; j -= 2) {
/* 1254 */         if (arrayOfObject[j] == ActionListener.class)
/*      */         {
/* 1256 */           if (localActionEvent == null) {
/* 1257 */             localActionEvent = new ActionEvent(this, 1001, getActionCommand(), l, i);
/*      */           }
/*      */ 
/* 1260 */           ((ActionListener)arrayOfObject[(j + 1)]).actionPerformed(localActionEvent);
/*      */         }
/*      */       }
/* 1263 */       this.firingActionEvent = false;
/*      */     }
/*      */   }
/*      */ 
/*      */   protected void selectedItemChanged()
/*      */   {
/* 1272 */     if (this.selectedItemReminder != null) {
/* 1273 */       fireItemStateChanged(new ItemEvent(this, 701, this.selectedItemReminder, 2));
/*      */     }
/*      */ 
/* 1279 */     this.selectedItemReminder = this.dataModel.getSelectedItem();
/*      */ 
/* 1281 */     if (this.selectedItemReminder != null)
/* 1282 */       fireItemStateChanged(new ItemEvent(this, 701, this.selectedItemReminder, 1));
/*      */   }
/*      */ 
/*      */   public Object[] getSelectedObjects()
/*      */   {
/* 1297 */     Object localObject = getSelectedItem();
/* 1298 */     if (localObject == null) {
/* 1299 */       return new Object[0];
/*      */     }
/* 1301 */     Object[] arrayOfObject = new Object[1];
/* 1302 */     arrayOfObject[0] = localObject;
/* 1303 */     return arrayOfObject;
/*      */   }
/*      */ 
/*      */   public void actionPerformed(ActionEvent paramActionEvent)
/*      */   {
/* 1312 */     Object localObject = getEditor().getItem();
/* 1313 */     setPopupVisible(false);
/* 1314 */     getModel().setSelectedItem(localObject);
/* 1315 */     String str = getActionCommand();
/* 1316 */     setActionCommand("comboBoxEdited");
/* 1317 */     fireActionEvent();
/* 1318 */     setActionCommand(str);
/*      */   }
/*      */ 
/*      */   public void contentsChanged(ListDataEvent paramListDataEvent)
/*      */   {
/* 1326 */     Object localObject1 = this.selectedItemReminder;
/* 1327 */     Object localObject2 = this.dataModel.getSelectedItem();
/* 1328 */     if ((localObject1 == null) || (!localObject1.equals(localObject2))) {
/* 1329 */       selectedItemChanged();
/* 1330 */       if (!this.selectingItem)
/* 1331 */         fireActionEvent();
/*      */     }
/*      */   }
/*      */ 
/*      */   public void intervalAdded(ListDataEvent paramListDataEvent)
/*      */   {
/* 1341 */     if (this.selectedItemReminder != this.dataModel.getSelectedItem())
/* 1342 */       selectedItemChanged();
/*      */   }
/*      */ 
/*      */   public void intervalRemoved(ListDataEvent paramListDataEvent)
/*      */   {
/* 1351 */     contentsChanged(paramListDataEvent);
/*      */   }
/*      */ 
/*      */   public boolean selectWithKeyChar(char paramChar)
/*      */   {
/* 1365 */     if (this.keySelectionManager == null) {
/* 1366 */       this.keySelectionManager = createDefaultKeySelectionManager();
/*      */     }
/* 1368 */     int i = this.keySelectionManager.selectionForKey(paramChar, getModel());
/* 1369 */     if (i != -1) {
/* 1370 */       setSelectedIndex(i);
/* 1371 */       return true;
/*      */     }
/*      */ 
/* 1374 */     return false;
/*      */   }
/*      */ 
/*      */   public void setEnabled(boolean paramBoolean)
/*      */   {
/* 1390 */     super.setEnabled(paramBoolean);
/* 1391 */     firePropertyChange("enabled", !isEnabled(), isEnabled());
/*      */   }
/*      */ 
/*      */   public void configureEditor(ComboBoxEditor paramComboBoxEditor, Object paramObject)
/*      */   {
/* 1403 */     paramComboBoxEditor.setItem(paramObject);
/*      */   }
/*      */ 
/*      */   public void processKeyEvent(KeyEvent paramKeyEvent)
/*      */   {
/* 1414 */     if (paramKeyEvent.getKeyCode() == 9) {
/* 1415 */       hidePopup();
/*      */     }
/* 1417 */     super.processKeyEvent(paramKeyEvent);
/*      */   }
/*      */ 
/*      */   public void setKeySelectionManager(KeySelectionManager paramKeySelectionManager)
/*      */   {
/* 1430 */     this.keySelectionManager = paramKeySelectionManager;
/*      */   }
/*      */ 
/*      */   public KeySelectionManager getKeySelectionManager()
/*      */   {
/* 1439 */     return this.keySelectionManager;
/*      */   }
/*      */ 
/*      */   public int getItemCount()
/*      */   {
/* 1449 */     return this.dataModel.getSize();
/*      */   }
/*      */ 
/*      */   public E getItemAt(int paramInt)
/*      */   {
/* 1463 */     return this.dataModel.getElementAt(paramInt);
/*      */   }
/*      */ 
/*      */   protected KeySelectionManager createDefaultKeySelectionManager()
/*      */   {
/* 1473 */     return new DefaultKeySelectionManager();
/*      */   }
/*      */ 
/*      */   private void writeObject(ObjectOutputStream paramObjectOutputStream)
/*      */     throws IOException
/*      */   {
/* 1547 */     paramObjectOutputStream.defaultWriteObject();
/* 1548 */     if (getUIClassID().equals("ComboBoxUI")) {
/* 1549 */       byte b = JComponent.getWriteObjCounter(this);
/* 1550 */       b = (byte)(b - 1); JComponent.setWriteObjCounter(this, b);
/* 1551 */       if ((b == 0) && (this.ui != null))
/* 1552 */         this.ui.installUI(this);
/*      */     }
/*      */   }
/*      */ 
/*      */   protected String paramString()
/*      */   {
/* 1568 */     String str1 = this.selectedItemReminder != null ? this.selectedItemReminder.toString() : "";
/*      */ 
/* 1571 */     String str2 = this.isEditable ? "true" : "false";
/* 1572 */     String str3 = this.lightWeightPopupEnabled ? "true" : "false";
/*      */ 
/* 1575 */     return super.paramString() + ",isEditable=" + str2 + ",lightWeightPopupEnabled=" + str3 + ",maximumRowCount=" + this.maximumRowCount + ",selectedItemReminder=" + str1;
/*      */   }
/*      */ 
/*      */   public AccessibleContext getAccessibleContext()
/*      */   {
/* 1597 */     if (this.accessibleContext == null) {
/* 1598 */       this.accessibleContext = new AccessibleJComboBox();
/*      */     }
/* 1600 */     return this.accessibleContext;
/*      */   }
/*      */ 
/*      */   protected class AccessibleJComboBox extends JComponent.AccessibleJComponent
/*      */     implements AccessibleAction, AccessibleSelection
/*      */   {
/*      */     private JList popupList;
/* 1622 */     private Accessible previousSelectedAccessible = null;
/*      */ 
/* 2032 */     private JComboBox<E>.AccessibleJComboBox.EditorAccessibleContext editorAccessibleContext = null;
/*      */ 
/*      */     public AccessibleJComboBox()
/*      */     {
/* 1628 */       super();
/*      */ 
/* 1630 */       JComboBox.this.addPropertyChangeListener(new AccessibleJComboBoxPropertyChangeListener(null));
/* 1631 */       setEditorNameAndDescription();
/*      */ 
/* 1634 */       Accessible localAccessible = JComboBox.this.getUI().getAccessibleChild(JComboBox.this, 0);
/* 1635 */       if ((localAccessible instanceof ComboPopup))
/*      */       {
/* 1637 */         this.popupList = ((ComboPopup)localAccessible).getList();
/* 1638 */         this.popupList.addListSelectionListener(new AccessibleJComboBoxListSelectionListener(null));
/*      */       }
/*      */ 
/* 1642 */       JComboBox.this.addPopupMenuListener(new AccessibleJComboBoxPopupMenuListener(null));
/*      */     }
/*      */ 
/*      */     private void setEditorNameAndDescription()
/*      */     {
/* 1665 */       ComboBoxEditor localComboBoxEditor = JComboBox.this.getEditor();
/* 1666 */       if (localComboBoxEditor != null) {
/* 1667 */         Component localComponent = localComboBoxEditor.getEditorComponent();
/* 1668 */         if ((localComponent instanceof Accessible)) {
/* 1669 */           AccessibleContext localAccessibleContext = localComponent.getAccessibleContext();
/* 1670 */           if (localAccessibleContext != null) {
/* 1671 */             localAccessibleContext.setAccessibleName(getAccessibleName());
/* 1672 */             localAccessibleContext.setAccessibleDescription(getAccessibleDescription());
/*      */           }
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */     public int getAccessibleChildrenCount()
/*      */     {
/* 1779 */       if (JComboBox.this.ui != null) {
/* 1780 */         return JComboBox.this.ui.getAccessibleChildrenCount(JComboBox.this);
/*      */       }
/* 1782 */       return super.getAccessibleChildrenCount();
/*      */     }
/*      */ 
/*      */     public Accessible getAccessibleChild(int paramInt)
/*      */     {
/* 1797 */       if (JComboBox.this.ui != null) {
/* 1798 */         return JComboBox.this.ui.getAccessibleChild(JComboBox.this, paramInt);
/*      */       }
/* 1800 */       return super.getAccessibleChild(paramInt);
/*      */     }
/*      */ 
/*      */     public AccessibleRole getAccessibleRole()
/*      */     {
/* 1812 */       return AccessibleRole.COMBO_BOX;
/*      */     }
/*      */ 
/*      */     public AccessibleStateSet getAccessibleStateSet()
/*      */     {
/* 1831 */       AccessibleStateSet localAccessibleStateSet = super.getAccessibleStateSet();
/* 1832 */       if (localAccessibleStateSet == null) {
/* 1833 */         localAccessibleStateSet = new AccessibleStateSet();
/*      */       }
/* 1835 */       if (JComboBox.this.isPopupVisible())
/* 1836 */         localAccessibleStateSet.add(AccessibleState.EXPANDED);
/*      */       else {
/* 1838 */         localAccessibleStateSet.add(AccessibleState.COLLAPSED);
/*      */       }
/* 1840 */       return localAccessibleStateSet;
/*      */     }
/*      */ 
/*      */     public AccessibleAction getAccessibleAction()
/*      */     {
/* 1852 */       return this;
/*      */     }
/*      */ 
/*      */     public String getAccessibleActionDescription(int paramInt)
/*      */     {
/* 1861 */       if (paramInt == 0) {
/* 1862 */         return UIManager.getString("ComboBox.togglePopupText");
/*      */       }
/*      */ 
/* 1865 */       return null;
/*      */     }
/*      */ 
/*      */     public int getAccessibleActionCount()
/*      */     {
/* 1876 */       return 1;
/*      */     }
/*      */ 
/*      */     public boolean doAccessibleAction(int paramInt)
/*      */     {
/* 1886 */       if (paramInt == 0) {
/* 1887 */         JComboBox.this.setPopupVisible(!JComboBox.this.isPopupVisible());
/* 1888 */         return true;
/*      */       }
/*      */ 
/* 1891 */       return false;
/*      */     }
/*      */ 
/*      */     public AccessibleSelection getAccessibleSelection()
/*      */     {
/* 1905 */       return this;
/*      */     }
/*      */ 
/*      */     public int getAccessibleSelectionCount()
/*      */     {
/* 1916 */       Object localObject = JComboBox.this.getSelectedItem();
/* 1917 */       if (localObject != null) {
/* 1918 */         return 1;
/*      */       }
/* 1920 */       return 0;
/*      */     }
/*      */ 
/*      */     public Accessible getAccessibleSelection(int paramInt)
/*      */     {
/* 1939 */       Accessible localAccessible = JComboBox.this.getUI().getAccessibleChild(JComboBox.this, 0);
/*      */ 
/* 1941 */       if ((localAccessible != null) && ((localAccessible instanceof ComboPopup)))
/*      */       {
/* 1945 */         JList localJList = ((ComboPopup)localAccessible).getList();
/*      */ 
/* 1948 */         AccessibleContext localAccessibleContext = localJList.getAccessibleContext();
/* 1949 */         if (localAccessibleContext != null) {
/* 1950 */           AccessibleSelection localAccessibleSelection = localAccessibleContext.getAccessibleSelection();
/* 1951 */           if (localAccessibleSelection != null) {
/* 1952 */             return localAccessibleSelection.getAccessibleSelection(paramInt);
/*      */           }
/*      */         }
/*      */       }
/* 1956 */       return null;
/*      */     }
/*      */ 
/*      */     public boolean isAccessibleChildSelected(int paramInt)
/*      */     {
/* 1970 */       return JComboBox.this.getSelectedIndex() == paramInt;
/*      */     }
/*      */ 
/*      */     public void addAccessibleSelection(int paramInt)
/*      */     {
/* 1986 */       clearAccessibleSelection();
/* 1987 */       JComboBox.this.setSelectedIndex(paramInt);
/*      */     }
/*      */ 
/*      */     public void removeAccessibleSelection(int paramInt)
/*      */     {
/* 2000 */       if (JComboBox.this.getSelectedIndex() == paramInt)
/* 2001 */         clearAccessibleSelection();
/*      */     }
/*      */ 
/*      */     public void clearAccessibleSelection()
/*      */     {
/* 2011 */       JComboBox.this.setSelectedIndex(-1);
/*      */     }
/*      */ 
/*      */     public void selectAllAccessibleSelection()
/*      */     {
/*      */     }
/*      */ 
/*      */     private class AccessibleEditor
/*      */       implements Accessible
/*      */     {
/*      */       private AccessibleEditor()
/*      */       {
/*      */       }
/*      */ 
/*      */       public AccessibleContext getAccessibleContext()
/*      */       {
/* 2036 */         if (JComboBox.AccessibleJComboBox.this.editorAccessibleContext == null) {
/* 2037 */           Component localComponent = JComboBox.this.getEditor().getEditorComponent();
/* 2038 */           if ((localComponent instanceof Accessible)) {
/* 2039 */             JComboBox.AccessibleJComboBox.this.editorAccessibleContext = new JComboBox.AccessibleJComboBox.EditorAccessibleContext(JComboBox.AccessibleJComboBox.this, (Accessible)localComponent);
/*      */           }
/*      */         }
/*      */ 
/* 2043 */         return JComboBox.AccessibleJComboBox.this.editorAccessibleContext;
/*      */       }
/*      */     }
/*      */ 
/*      */     private class AccessibleJComboBoxListSelectionListener
/*      */       implements ListSelectionListener
/*      */     {
/*      */       private AccessibleJComboBoxListSelectionListener()
/*      */       {
/*      */       }
/*      */ 
/*      */       public void valueChanged(ListSelectionEvent paramListSelectionEvent)
/*      */       {
/* 1725 */         if (JComboBox.AccessibleJComboBox.this.popupList == null) {
/* 1726 */           return;
/*      */         }
/*      */ 
/* 1730 */         int i = JComboBox.AccessibleJComboBox.this.popupList.getSelectedIndex();
/* 1731 */         if (i < 0) {
/* 1732 */           return;
/*      */         }
/* 1734 */         Accessible localAccessible = JComboBox.AccessibleJComboBox.this.popupList.getAccessibleContext().getAccessibleChild(i);
/*      */ 
/* 1736 */         if (localAccessible == null) {
/* 1737 */           return;
/*      */         }
/*      */ 
/* 1744 */         if (JComboBox.AccessibleJComboBox.this.previousSelectedAccessible != null) {
/* 1745 */           localPropertyChangeEvent = new PropertyChangeEvent(JComboBox.AccessibleJComboBox.this.previousSelectedAccessible, "AccessibleState", AccessibleState.FOCUSED, null);
/*      */ 
/* 1748 */           JComboBox.AccessibleJComboBox.this.firePropertyChange("AccessibleState", null, localPropertyChangeEvent);
/*      */         }
/*      */ 
/* 1753 */         PropertyChangeEvent localPropertyChangeEvent = new PropertyChangeEvent(localAccessible, "AccessibleState", null, AccessibleState.FOCUSED);
/*      */ 
/* 1756 */         JComboBox.AccessibleJComboBox.this.firePropertyChange("AccessibleState", null, localPropertyChangeEvent);
/*      */ 
/* 1761 */         JComboBox.AccessibleJComboBox.this.firePropertyChange("AccessibleActiveDescendant", JComboBox.AccessibleJComboBox.this.previousSelectedAccessible, localAccessible);
/*      */ 
/* 1765 */         JComboBox.AccessibleJComboBox.this.previousSelectedAccessible = localAccessible;
/*      */       }
/*      */     }
/*      */ 
/*      */     private class AccessibleJComboBoxPopupMenuListener
/*      */       implements PopupMenuListener
/*      */     {
/*      */       private AccessibleJComboBoxPopupMenuListener()
/*      */       {
/*      */       }
/*      */ 
/*      */       public void popupMenuWillBecomeVisible(PopupMenuEvent paramPopupMenuEvent)
/*      */       {
/* 1690 */         if (JComboBox.AccessibleJComboBox.this.popupList == null) {
/* 1691 */           return;
/*      */         }
/* 1693 */         int i = JComboBox.AccessibleJComboBox.this.popupList.getSelectedIndex();
/* 1694 */         if (i < 0) {
/* 1695 */           return;
/*      */         }
/* 1697 */         JComboBox.AccessibleJComboBox.this.previousSelectedAccessible = JComboBox.AccessibleJComboBox.this.popupList.getAccessibleContext().getAccessibleChild(i);
/*      */       }
/*      */ 
/*      */       public void popupMenuWillBecomeInvisible(PopupMenuEvent paramPopupMenuEvent)
/*      */       {
/*      */       }
/*      */ 
/*      */       public void popupMenuCanceled(PopupMenuEvent paramPopupMenuEvent)
/*      */       {
/*      */       }
/*      */     }
/*      */ 
/*      */     private class AccessibleJComboBoxPropertyChangeListener
/*      */       implements PropertyChangeListener
/*      */     {
/*      */       private AccessibleJComboBoxPropertyChangeListener()
/*      */       {
/*      */       }
/*      */ 
/*      */       public void propertyChange(PropertyChangeEvent paramPropertyChangeEvent)
/*      */       {
/* 1653 */         if (paramPropertyChangeEvent.getPropertyName() == "editor")
/*      */         {
/* 1656 */           JComboBox.AccessibleJComboBox.this.setEditorNameAndDescription();
/*      */         }
/*      */       }
/*      */     }
/*      */ 
/*      */     private class EditorAccessibleContext extends AccessibleContext
/*      */     {
/*      */       private AccessibleContext ac;
/*      */ 
/*      */       private EditorAccessibleContext()
/*      */       {
/*      */       }
/*      */ 
/*      */       EditorAccessibleContext(Accessible arg2)
/*      */       {
/*      */         Object localObject;
/* 2066 */         this.ac = localObject.getAccessibleContext();
/*      */       }
/*      */ 
/*      */       public String getAccessibleName()
/*      */       {
/* 2085 */         return this.ac.getAccessibleName();
/*      */       }
/*      */ 
/*      */       public void setAccessibleName(String paramString)
/*      */       {
/* 2103 */         this.ac.setAccessibleName(paramString);
/*      */       }
/*      */ 
/*      */       public String getAccessibleDescription()
/*      */       {
/* 2119 */         return this.ac.getAccessibleDescription();
/*      */       }
/*      */ 
/*      */       public void setAccessibleDescription(String paramString)
/*      */       {
/* 2137 */         this.ac.setAccessibleDescription(paramString);
/*      */       }
/*      */ 
/*      */       public AccessibleRole getAccessibleRole()
/*      */       {
/* 2159 */         return this.ac.getAccessibleRole();
/*      */       }
/*      */ 
/*      */       public AccessibleStateSet getAccessibleStateSet()
/*      */       {
/* 2175 */         return this.ac.getAccessibleStateSet();
/*      */       }
/*      */ 
/*      */       public Accessible getAccessibleParent()
/*      */       {
/* 2185 */         return this.ac.getAccessibleParent();
/*      */       }
/*      */ 
/*      */       public void setAccessibleParent(Accessible paramAccessible)
/*      */       {
/* 2197 */         this.ac.setAccessibleParent(paramAccessible);
/*      */       }
/*      */ 
/*      */       public int getAccessibleIndexInParent()
/*      */       {
/* 2211 */         return JComboBox.this.getSelectedIndex();
/*      */       }
/*      */ 
/*      */       public int getAccessibleChildrenCount()
/*      */       {
/* 2220 */         return this.ac.getAccessibleChildrenCount();
/*      */       }
/*      */ 
/*      */       public Accessible getAccessibleChild(int paramInt)
/*      */       {
/* 2234 */         return this.ac.getAccessibleChild(paramInt);
/*      */       }
/*      */ 
/*      */       public Locale getLocale()
/*      */         throws IllegalComponentStateException
/*      */       {
/* 2250 */         return this.ac.getLocale();
/*      */       }
/*      */ 
/*      */       public void addPropertyChangeListener(PropertyChangeListener paramPropertyChangeListener)
/*      */       {
/* 2269 */         this.ac.addPropertyChangeListener(paramPropertyChangeListener);
/*      */       }
/*      */ 
/*      */       public void removePropertyChangeListener(PropertyChangeListener paramPropertyChangeListener)
/*      */       {
/* 2280 */         this.ac.removePropertyChangeListener(paramPropertyChangeListener);
/*      */       }
/*      */ 
/*      */       public AccessibleAction getAccessibleAction()
/*      */       {
/* 2291 */         return this.ac.getAccessibleAction();
/*      */       }
/*      */ 
/*      */       public AccessibleComponent getAccessibleComponent()
/*      */       {
/* 2302 */         return this.ac.getAccessibleComponent();
/*      */       }
/*      */ 
/*      */       public AccessibleSelection getAccessibleSelection()
/*      */       {
/* 2313 */         return this.ac.getAccessibleSelection();
/*      */       }
/*      */ 
/*      */       public AccessibleText getAccessibleText()
/*      */       {
/* 2324 */         return this.ac.getAccessibleText();
/*      */       }
/*      */ 
/*      */       public AccessibleEditableText getAccessibleEditableText()
/*      */       {
/* 2335 */         return this.ac.getAccessibleEditableText();
/*      */       }
/*      */ 
/*      */       public AccessibleValue getAccessibleValue()
/*      */       {
/* 2346 */         return this.ac.getAccessibleValue();
/*      */       }
/*      */ 
/*      */       public AccessibleIcon[] getAccessibleIcon()
/*      */       {
/* 2358 */         return this.ac.getAccessibleIcon();
/*      */       }
/*      */ 
/*      */       public AccessibleRelationSet getAccessibleRelationSet()
/*      */       {
/* 2369 */         return this.ac.getAccessibleRelationSet();
/*      */       }
/*      */ 
/*      */       public AccessibleTable getAccessibleTable()
/*      */       {
/* 2380 */         return this.ac.getAccessibleTable();
/*      */       }
/*      */ 
/*      */       public void firePropertyChange(String paramString, Object paramObject1, Object paramObject2)
/*      */       {
/* 2407 */         this.ac.firePropertyChange(paramString, paramObject1, paramObject2);
/*      */       }
/*      */     }
/*      */   }
/*      */ 
/*      */   private static class ComboBoxActionPropertyChangeListener extends ActionPropertyChangeListener<JComboBox<?>>
/*      */   {
/*      */     ComboBoxActionPropertyChangeListener(JComboBox<?> paramJComboBox, Action paramAction)
/*      */     {
/* 1195 */       super(paramAction);
/*      */     }
/*      */ 
/*      */     protected void actionPropertyChanged(JComboBox<?> paramJComboBox, Action paramAction, PropertyChangeEvent paramPropertyChangeEvent)
/*      */     {
/* 1200 */       if (AbstractAction.shouldReconfigure(paramPropertyChangeEvent))
/* 1201 */         paramJComboBox.configurePropertiesFromAction(paramAction);
/*      */       else
/* 1203 */         paramJComboBox.actionPropertyChanged(paramAction, paramPropertyChangeEvent.getPropertyName());
/*      */     }
/*      */   }
/*      */ 
/*      */   class DefaultKeySelectionManager
/*      */     implements JComboBox.KeySelectionManager, Serializable
/*      */   {
/*      */     DefaultKeySelectionManager()
/*      */     {
/*      */     }
/*      */ 
/*      */     public int selectionForKey(char paramChar, ComboBoxModel paramComboBoxModel)
/*      */     {
/* 1502 */       int k = -1;
/* 1503 */       Object localObject1 = paramComboBoxModel.getSelectedItem();
/*      */ 
/* 1507 */       if (localObject1 != null) {
/* 1508 */         i = 0; for (j = paramComboBoxModel.getSize(); i < j; i++) {
/* 1509 */           if (localObject1 == paramComboBoxModel.getElementAt(i)) {
/* 1510 */             k = i;
/* 1511 */             break;
/*      */           }
/*      */         }
/*      */       }
/*      */ 
/* 1516 */       String str2 = ("" + paramChar).toLowerCase();
/* 1517 */       paramChar = str2.charAt(0);
/*      */ 
/* 1519 */       k++; int i = k;
/*      */       Object localObject2;
/*      */       String str1;
/* 1519 */       for (int j = paramComboBoxModel.getSize(); i < j; i++) {
/* 1520 */         localObject2 = paramComboBoxModel.getElementAt(i);
/* 1521 */         if ((localObject2 != null) && (localObject2.toString() != null)) {
/* 1522 */           str1 = localObject2.toString().toLowerCase();
/* 1523 */           if ((str1.length() > 0) && (str1.charAt(0) == paramChar)) {
/* 1524 */             return i;
/*      */           }
/*      */         }
/*      */       }
/* 1528 */       for (i = 0; i < k; i++) {
/* 1529 */         localObject2 = paramComboBoxModel.getElementAt(i);
/* 1530 */         if ((localObject2 != null) && (localObject2.toString() != null)) {
/* 1531 */           str1 = localObject2.toString().toLowerCase();
/* 1532 */           if ((str1.length() > 0) && (str1.charAt(0) == paramChar))
/* 1533 */             return i;
/*      */         }
/*      */       }
/* 1536 */       return -1;
/*      */     }
/*      */   }
/*      */ 
/*      */   public static abstract interface KeySelectionManager
/*      */   {
/*      */     public abstract int selectionForKey(char paramChar, ComboBoxModel paramComboBoxModel);
/*      */   }
/*      */ }

/* Location:           /home/user1/Temp/jvm/rt.jar
 * Qualified Name:     javax.swing.JComboBox
 * JD-Core Version:    0.6.2
 */