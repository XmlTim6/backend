
package team6.xml_project.models.xml.paper;

import java.util.ArrayList;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;choice maxOccurs="unbounded">
 *         &lt;element ref="{XML_tim6}paragraph"/>
 *         &lt;element ref="{XML_tim6}image"/>
 *         &lt;element name="list">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="list_item" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *                 &lt;attribute name="type" use="required">
 *                   &lt;simpleType>
 *                     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                       &lt;enumeration value="ordered"/>
 *                       &lt;enumeration value="unordered"/>
 *                     &lt;/restriction>
 *                   &lt;/simpleType>
 *                 &lt;/attribute>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element ref="{XML_tim6}quote"/>
 *         &lt;element ref="{XML_tim6}section"/>
 *         &lt;element ref="{XML_tim6}code"/>
 *         &lt;element ref="{XML_tim6}formula"/>
 *         &lt;element name="table">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence maxOccurs="unbounded">
 *                   &lt;element name="row">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence maxOccurs="unbounded">
 *                             &lt;element name="cell">
 *                               &lt;complexType>
 *                                 &lt;complexContent>
 *                                   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                                     &lt;choice minOccurs="0">
 *                                       &lt;element ref="{XML_tim6}paragraph"/>
 *                                     &lt;/choice>
 *                                     &lt;attribute name="colspan" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" default="1" />
 *                                     &lt;attribute name="rowspan" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" default="1" />
 *                                   &lt;/restriction>
 *                                 &lt;/complexContent>
 *                               &lt;/complexType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *                 &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/choice>
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
 *       &lt;attribute name="title" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="level" use="required" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "paragraphOrImageOrList"
})
@XmlRootElement(name = "section")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class Section {

    @XmlElements({
        @XmlElement(name = "paragraph", type = Paragraph.class),
        @XmlElement(name = "image", type = Image.class),
        @XmlElement(name = "list", type = List.class),
        @XmlElement(name = "quote", type = Quote.class),
        @XmlElement(name = "section", type = Section.class),
        @XmlElement(name = "code", type = Code.class),
        @XmlElement(name = "formula", type = Formula.class),
        @XmlElement(name = "table", type = Table.class)
    })
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected java.util.List<Object> paragraphOrImageOrList;
    @XmlAttribute(name = "id", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String id;
    @XmlAttribute(name = "title", required = true)
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected String title;
    @XmlAttribute(name = "level", required = true)
    @XmlSchemaType(name = "unsignedInt")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected long level;

    /**
     * Gets the value of the paragraphOrImageOrList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paragraphOrImageOrList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParagraphOrImageOrList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Paragraph }
     * {@link Image }
     * {@link List }
     * {@link Quote }
     * {@link Section }
     * {@link Code }
     * {@link Formula }
     * {@link Table }
     * 
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public java.util.List<Object> getParagraphOrImageOrList() {
        if (paragraphOrImageOrList == null) {
            paragraphOrImageOrList = new ArrayList<Object>();
        }
        return this.paragraphOrImageOrList;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public String getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Gets the value of the level property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public long getLevel() {
        return level;
    }

    /**
     * Sets the value of the level property.
     * 
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setLevel(long value) {
        this.level = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="list_item" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *       &lt;/sequence>
     *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
     *       &lt;attribute name="type" use="required">
     *         &lt;simpleType>
     *           &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *             &lt;enumeration value="ordered"/>
     *             &lt;enumeration value="unordered"/>
     *           &lt;/restriction>
     *         &lt;/simpleType>
     *       &lt;/attribute>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "listItem"
    })
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public static class List {

        @XmlElement(name = "list_item", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String listItem;
        @XmlAttribute(name = "id", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
        @XmlSchemaType(name = "ID")
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String id;
        @XmlAttribute(name = "type", required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String type;

        /**
         * Gets the value of the listItem property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getListItem() {
            return listItem;
        }

        /**
         * Sets the value of the listItem property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setListItem(String value) {
            this.listItem = value;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setId(String value) {
            this.id = value;
        }

        /**
         * Gets the value of the type property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getType() {
            return type;
        }

        /**
         * Sets the value of the type property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setType(String value) {
            this.type = value;
        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence maxOccurs="unbounded">
     *         &lt;element name="row">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence maxOccurs="unbounded">
     *                   &lt;element name="cell">
     *                     &lt;complexType>
     *                       &lt;complexContent>
     *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                           &lt;choice minOccurs="0">
     *                             &lt;element ref="{XML_tim6}paragraph"/>
     *                           &lt;/choice>
     *                           &lt;attribute name="colspan" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" default="1" />
     *                           &lt;attribute name="rowspan" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" default="1" />
     *                         &lt;/restriction>
     *                       &lt;/complexContent>
     *                     &lt;/complexType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}ID" />
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "row"
    })
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public static class Table {

        @XmlElement(required = true)
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected java.util.List<Row> row;
        @XmlAttribute(name = "id", required = true)
        @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
        @XmlID
        @XmlSchemaType(name = "ID")
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        protected String id;

        /**
         * Gets the value of the row property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the row property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getRow().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Row }
         * 
         * 
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public java.util.List<Row> getRow() {
            if (row == null) {
                row = new ArrayList<Row>();
            }
            return this.row;
        }

        /**
         * Gets the value of the id property.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public String getId() {
            return id;
        }

        /**
         * Sets the value of the id property.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public void setId(String value) {
            this.id = value;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence maxOccurs="unbounded">
         *         &lt;element name="cell">
         *           &lt;complexType>
         *             &lt;complexContent>
         *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *                 &lt;choice minOccurs="0">
         *                   &lt;element ref="{XML_tim6}paragraph"/>
         *                 &lt;/choice>
         *                 &lt;attribute name="colspan" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" default="1" />
         *                 &lt;attribute name="rowspan" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" default="1" />
         *               &lt;/restriction>
         *             &lt;/complexContent>
         *           &lt;/complexType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "cell"
        })
        @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
        public static class Row {

            @XmlElement(required = true)
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            protected java.util.List<Cell> cell;

            /**
             * Gets the value of the cell property.
             * 
             * <p>
             * This accessor method returns a reference to the live list,
             * not a snapshot. Therefore any modification you make to the
             * returned list will be present inside the JAXB object.
             * This is why there is not a <CODE>set</CODE> method for the cell property.
             * 
             * <p>
             * For example, to add a new item, do as follows:
             * <pre>
             *    getCell().add(newItem);
             * </pre>
             * 
             * 
             * <p>
             * Objects of the following type(s) are allowed in the list
             * {@link Cell }
             * 
             * 
             */
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            public java.util.List<Cell> getCell() {
                if (cell == null) {
                    cell = new ArrayList<Cell>();
                }
                return this.cell;
            }


            /**
             * <p>Java class for anonymous complex type.
             * 
             * <p>The following schema fragment specifies the expected content contained within this class.
             * 
             * <pre>
             * &lt;complexType>
             *   &lt;complexContent>
             *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
             *       &lt;choice minOccurs="0">
             *         &lt;element ref="{XML_tim6}paragraph"/>
             *       &lt;/choice>
             *       &lt;attribute name="colspan" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" default="1" />
             *       &lt;attribute name="rowspan" type="{http://www.w3.org/2001/XMLSchema}unsignedInt" default="1" />
             *     &lt;/restriction>
             *   &lt;/complexContent>
             * &lt;/complexType>
             * </pre>
             * 
             * 
             */
            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "paragraph"
            })
            @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
            public static class Cell {

                @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
                protected Paragraph paragraph;
                @XmlAttribute(name = "colspan")
                @XmlSchemaType(name = "unsignedInt")
                @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
                protected Long colspan;
                @XmlAttribute(name = "rowspan")
                @XmlSchemaType(name = "unsignedInt")
                @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
                protected Long rowspan;

                /**
                 * Gets the value of the paragraph property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Paragraph }
                 *     
                 */
                @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
                public Paragraph getParagraph() {
                    return paragraph;
                }

                /**
                 * Sets the value of the paragraph property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Paragraph }
                 *     
                 */
                @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
                public void setParagraph(Paragraph value) {
                    this.paragraph = value;
                }

                /**
                 * Gets the value of the colspan property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Long }
                 *     
                 */
                @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
                public long getColspan() {
                    if (colspan == null) {
                        return  1L;
                    } else {
                        return colspan;
                    }
                }

                /**
                 * Sets the value of the colspan property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Long }
                 *     
                 */
                @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
                public void setColspan(Long value) {
                    this.colspan = value;
                }

                /**
                 * Gets the value of the rowspan property.
                 * 
                 * @return
                 *     possible object is
                 *     {@link Long }
                 *     
                 */
                @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
                public long getRowspan() {
                    if (rowspan == null) {
                        return  1L;
                    } else {
                        return rowspan;
                    }
                }

                /**
                 * Sets the value of the rowspan property.
                 * 
                 * @param value
                 *     allowed object is
                 *     {@link Long }
                 *     
                 */
                @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-12-04T04:10:17+01:00", comments = "JAXB RI v2.2.8-b130911.1802")
                public void setRowspan(Long value) {
                    this.rowspan = value;
                }

            }

        }

    }

}
