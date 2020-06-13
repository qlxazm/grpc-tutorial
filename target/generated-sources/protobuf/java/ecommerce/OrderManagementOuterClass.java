// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: order_management.proto

package ecommerce;

public final class OrderManagementOuterClass {
  private OrderManagementOuterClass() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface OrderOrBuilder extends
      // @@protoc_insertion_point(interface_extends:ecommerce.Order)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string id = 1;</code>
     * @return The id.
     */
    java.lang.String getId();
    /**
     * <code>string id = 1;</code>
     * @return The bytes for id.
     */
    com.google.protobuf.ByteString
        getIdBytes();

    /**
     * <code>repeated string items = 2;</code>
     * @return A list containing the items.
     */
    java.util.List<java.lang.String>
        getItemsList();
    /**
     * <code>repeated string items = 2;</code>
     * @return The count of items.
     */
    int getItemsCount();
    /**
     * <code>repeated string items = 2;</code>
     * @param index The index of the element to return.
     * @return The items at the given index.
     */
    java.lang.String getItems(int index);
    /**
     * <code>repeated string items = 2;</code>
     * @param index The index of the value to return.
     * @return The bytes of the items at the given index.
     */
    com.google.protobuf.ByteString
        getItemsBytes(int index);

    /**
     * <code>string description = 3;</code>
     * @return The description.
     */
    java.lang.String getDescription();
    /**
     * <code>string description = 3;</code>
     * @return The bytes for description.
     */
    com.google.protobuf.ByteString
        getDescriptionBytes();

    /**
     * <code>float price = 4;</code>
     * @return The price.
     */
    float getPrice();

    /**
     * <code>string destination = 5;</code>
     * @return The destination.
     */
    java.lang.String getDestination();
    /**
     * <code>string destination = 5;</code>
     * @return The bytes for destination.
     */
    com.google.protobuf.ByteString
        getDestinationBytes();
  }
  /**
   * Protobuf type {@code ecommerce.Order}
   */
  public  static final class Order extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:ecommerce.Order)
      OrderOrBuilder {
  private static final long serialVersionUID = 0L;
    // Use Order.newBuilder() to construct.
    private Order(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Order() {
      id_ = "";
      items_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      description_ = "";
      destination_ = "";
    }

    @java.lang.Override
    @SuppressWarnings({"unused"})
    protected java.lang.Object newInstance(
        UnusedPrivateParameter unused) {
      return new Order();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return this.unknownFields;
    }
    private Order(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      if (extensionRegistry == null) {
        throw new java.lang.NullPointerException();
      }
      int mutable_bitField0_ = 0;
      com.google.protobuf.UnknownFieldSet.Builder unknownFields =
          com.google.protobuf.UnknownFieldSet.newBuilder();
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              id_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();
              if (!((mutable_bitField0_ & 0x00000001) != 0)) {
                items_ = new com.google.protobuf.LazyStringArrayList();
                mutable_bitField0_ |= 0x00000001;
              }
              items_.add(s);
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              description_ = s;
              break;
            }
            case 37: {

              price_ = input.readFloat();
              break;
            }
            case 42: {
              java.lang.String s = input.readStringRequireUtf8();

              destination_ = s;
              break;
            }
            default: {
              if (!parseUnknownField(
                  input, unknownFields, extensionRegistry, tag)) {
                done = true;
              }
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000001) != 0)) {
          items_ = items_.getUnmodifiableView();
        }
        this.unknownFields = unknownFields.build();
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return ecommerce.OrderManagementOuterClass.internal_static_ecommerce_Order_descriptor;
    }

    @java.lang.Override
    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return ecommerce.OrderManagementOuterClass.internal_static_ecommerce_Order_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              ecommerce.OrderManagementOuterClass.Order.class, ecommerce.OrderManagementOuterClass.Order.Builder.class);
    }

    public static final int ID_FIELD_NUMBER = 1;
    private volatile java.lang.Object id_;
    /**
     * <code>string id = 1;</code>
     * @return The id.
     */
    public java.lang.String getId() {
      java.lang.Object ref = id_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        id_ = s;
        return s;
      }
    }
    /**
     * <code>string id = 1;</code>
     * @return The bytes for id.
     */
    public com.google.protobuf.ByteString
        getIdBytes() {
      java.lang.Object ref = id_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        id_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ITEMS_FIELD_NUMBER = 2;
    private com.google.protobuf.LazyStringList items_;
    /**
     * <code>repeated string items = 2;</code>
     * @return A list containing the items.
     */
    public com.google.protobuf.ProtocolStringList
        getItemsList() {
      return items_;
    }
    /**
     * <code>repeated string items = 2;</code>
     * @return The count of items.
     */
    public int getItemsCount() {
      return items_.size();
    }
    /**
     * <code>repeated string items = 2;</code>
     * @param index The index of the element to return.
     * @return The items at the given index.
     */
    public java.lang.String getItems(int index) {
      return items_.get(index);
    }
    /**
     * <code>repeated string items = 2;</code>
     * @param index The index of the value to return.
     * @return The bytes of the items at the given index.
     */
    public com.google.protobuf.ByteString
        getItemsBytes(int index) {
      return items_.getByteString(index);
    }

    public static final int DESCRIPTION_FIELD_NUMBER = 3;
    private volatile java.lang.Object description_;
    /**
     * <code>string description = 3;</code>
     * @return The description.
     */
    public java.lang.String getDescription() {
      java.lang.Object ref = description_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        description_ = s;
        return s;
      }
    }
    /**
     * <code>string description = 3;</code>
     * @return The bytes for description.
     */
    public com.google.protobuf.ByteString
        getDescriptionBytes() {
      java.lang.Object ref = description_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        description_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PRICE_FIELD_NUMBER = 4;
    private float price_;
    /**
     * <code>float price = 4;</code>
     * @return The price.
     */
    public float getPrice() {
      return price_;
    }

    public static final int DESTINATION_FIELD_NUMBER = 5;
    private volatile java.lang.Object destination_;
    /**
     * <code>string destination = 5;</code>
     * @return The destination.
     */
    public java.lang.String getDestination() {
      java.lang.Object ref = destination_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        destination_ = s;
        return s;
      }
    }
    /**
     * <code>string destination = 5;</code>
     * @return The bytes for destination.
     */
    public com.google.protobuf.ByteString
        getDestinationBytes() {
      java.lang.Object ref = destination_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        destination_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    @java.lang.Override
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    @java.lang.Override
    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getIdBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, id_);
      }
      for (int i = 0; i < items_.size(); i++) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, items_.getRaw(i));
      }
      if (!getDescriptionBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, description_);
      }
      if (price_ != 0F) {
        output.writeFloat(4, price_);
      }
      if (!getDestinationBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, destination_);
      }
      unknownFields.writeTo(output);
    }

    @java.lang.Override
    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getIdBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, id_);
      }
      {
        int dataSize = 0;
        for (int i = 0; i < items_.size(); i++) {
          dataSize += computeStringSizeNoTag(items_.getRaw(i));
        }
        size += dataSize;
        size += 1 * getItemsList().size();
      }
      if (!getDescriptionBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, description_);
      }
      if (price_ != 0F) {
        size += com.google.protobuf.CodedOutputStream
          .computeFloatSize(4, price_);
      }
      if (!getDestinationBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, destination_);
      }
      size += unknownFields.getSerializedSize();
      memoizedSize = size;
      return size;
    }

    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof ecommerce.OrderManagementOuterClass.Order)) {
        return super.equals(obj);
      }
      ecommerce.OrderManagementOuterClass.Order other = (ecommerce.OrderManagementOuterClass.Order) obj;

      if (!getId()
          .equals(other.getId())) return false;
      if (!getItemsList()
          .equals(other.getItemsList())) return false;
      if (!getDescription()
          .equals(other.getDescription())) return false;
      if (java.lang.Float.floatToIntBits(getPrice())
          != java.lang.Float.floatToIntBits(
              other.getPrice())) return false;
      if (!getDestination()
          .equals(other.getDestination())) return false;
      if (!unknownFields.equals(other.unknownFields)) return false;
      return true;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + getId().hashCode();
      if (getItemsCount() > 0) {
        hash = (37 * hash) + ITEMS_FIELD_NUMBER;
        hash = (53 * hash) + getItemsList().hashCode();
      }
      hash = (37 * hash) + DESCRIPTION_FIELD_NUMBER;
      hash = (53 * hash) + getDescription().hashCode();
      hash = (37 * hash) + PRICE_FIELD_NUMBER;
      hash = (53 * hash) + java.lang.Float.floatToIntBits(
          getPrice());
      hash = (37 * hash) + DESTINATION_FIELD_NUMBER;
      hash = (53 * hash) + getDestination().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static ecommerce.OrderManagementOuterClass.Order parseFrom(
        java.nio.ByteBuffer data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ecommerce.OrderManagementOuterClass.Order parseFrom(
        java.nio.ByteBuffer data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ecommerce.OrderManagementOuterClass.Order parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ecommerce.OrderManagementOuterClass.Order parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ecommerce.OrderManagementOuterClass.Order parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static ecommerce.OrderManagementOuterClass.Order parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static ecommerce.OrderManagementOuterClass.Order parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ecommerce.OrderManagementOuterClass.Order parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static ecommerce.OrderManagementOuterClass.Order parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static ecommerce.OrderManagementOuterClass.Order parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static ecommerce.OrderManagementOuterClass.Order parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static ecommerce.OrderManagementOuterClass.Order parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    @java.lang.Override
    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(ecommerce.OrderManagementOuterClass.Order prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    @java.lang.Override
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code ecommerce.Order}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:ecommerce.Order)
        ecommerce.OrderManagementOuterClass.OrderOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return ecommerce.OrderManagementOuterClass.internal_static_ecommerce_Order_descriptor;
      }

      @java.lang.Override
      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return ecommerce.OrderManagementOuterClass.internal_static_ecommerce_Order_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                ecommerce.OrderManagementOuterClass.Order.class, ecommerce.OrderManagementOuterClass.Order.Builder.class);
      }

      // Construct using ecommerce.OrderManagementOuterClass.Order.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      @java.lang.Override
      public Builder clear() {
        super.clear();
        id_ = "";

        items_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        description_ = "";

        price_ = 0F;

        destination_ = "";

        return this;
      }

      @java.lang.Override
      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return ecommerce.OrderManagementOuterClass.internal_static_ecommerce_Order_descriptor;
      }

      @java.lang.Override
      public ecommerce.OrderManagementOuterClass.Order getDefaultInstanceForType() {
        return ecommerce.OrderManagementOuterClass.Order.getDefaultInstance();
      }

      @java.lang.Override
      public ecommerce.OrderManagementOuterClass.Order build() {
        ecommerce.OrderManagementOuterClass.Order result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      @java.lang.Override
      public ecommerce.OrderManagementOuterClass.Order buildPartial() {
        ecommerce.OrderManagementOuterClass.Order result = new ecommerce.OrderManagementOuterClass.Order(this);
        int from_bitField0_ = bitField0_;
        result.id_ = id_;
        if (((bitField0_ & 0x00000001) != 0)) {
          items_ = items_.getUnmodifiableView();
          bitField0_ = (bitField0_ & ~0x00000001);
        }
        result.items_ = items_;
        result.description_ = description_;
        result.price_ = price_;
        result.destination_ = destination_;
        onBuilt();
        return result;
      }

      @java.lang.Override
      public Builder clone() {
        return super.clone();
      }
      @java.lang.Override
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.setField(field, value);
      }
      @java.lang.Override
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return super.clearField(field);
      }
      @java.lang.Override
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return super.clearOneof(oneof);
      }
      @java.lang.Override
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, java.lang.Object value) {
        return super.setRepeatedField(field, index, value);
      }
      @java.lang.Override
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          java.lang.Object value) {
        return super.addRepeatedField(field, value);
      }
      @java.lang.Override
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof ecommerce.OrderManagementOuterClass.Order) {
          return mergeFrom((ecommerce.OrderManagementOuterClass.Order)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(ecommerce.OrderManagementOuterClass.Order other) {
        if (other == ecommerce.OrderManagementOuterClass.Order.getDefaultInstance()) return this;
        if (!other.getId().isEmpty()) {
          id_ = other.id_;
          onChanged();
        }
        if (!other.items_.isEmpty()) {
          if (items_.isEmpty()) {
            items_ = other.items_;
            bitField0_ = (bitField0_ & ~0x00000001);
          } else {
            ensureItemsIsMutable();
            items_.addAll(other.items_);
          }
          onChanged();
        }
        if (!other.getDescription().isEmpty()) {
          description_ = other.description_;
          onChanged();
        }
        if (other.getPrice() != 0F) {
          setPrice(other.getPrice());
        }
        if (!other.getDestination().isEmpty()) {
          destination_ = other.destination_;
          onChanged();
        }
        this.mergeUnknownFields(other.unknownFields);
        onChanged();
        return this;
      }

      @java.lang.Override
      public final boolean isInitialized() {
        return true;
      }

      @java.lang.Override
      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        ecommerce.OrderManagementOuterClass.Order parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (ecommerce.OrderManagementOuterClass.Order) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.lang.Object id_ = "";
      /**
       * <code>string id = 1;</code>
       * @return The id.
       */
      public java.lang.String getId() {
        java.lang.Object ref = id_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          id_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string id = 1;</code>
       * @return The bytes for id.
       */
      public com.google.protobuf.ByteString
          getIdBytes() {
        java.lang.Object ref = id_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          id_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string id = 1;</code>
       * @param value The id to set.
       * @return This builder for chaining.
       */
      public Builder setId(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string id = 1;</code>
       * @return This builder for chaining.
       */
      public Builder clearId() {
        
        id_ = getDefaultInstance().getId();
        onChanged();
        return this;
      }
      /**
       * <code>string id = 1;</code>
       * @param value The bytes for id to set.
       * @return This builder for chaining.
       */
      public Builder setIdBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        id_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.LazyStringList items_ = com.google.protobuf.LazyStringArrayList.EMPTY;
      private void ensureItemsIsMutable() {
        if (!((bitField0_ & 0x00000001) != 0)) {
          items_ = new com.google.protobuf.LazyStringArrayList(items_);
          bitField0_ |= 0x00000001;
         }
      }
      /**
       * <code>repeated string items = 2;</code>
       * @return A list containing the items.
       */
      public com.google.protobuf.ProtocolStringList
          getItemsList() {
        return items_.getUnmodifiableView();
      }
      /**
       * <code>repeated string items = 2;</code>
       * @return The count of items.
       */
      public int getItemsCount() {
        return items_.size();
      }
      /**
       * <code>repeated string items = 2;</code>
       * @param index The index of the element to return.
       * @return The items at the given index.
       */
      public java.lang.String getItems(int index) {
        return items_.get(index);
      }
      /**
       * <code>repeated string items = 2;</code>
       * @param index The index of the value to return.
       * @return The bytes of the items at the given index.
       */
      public com.google.protobuf.ByteString
          getItemsBytes(int index) {
        return items_.getByteString(index);
      }
      /**
       * <code>repeated string items = 2;</code>
       * @param index The index to set the value at.
       * @param value The items to set.
       * @return This builder for chaining.
       */
      public Builder setItems(
          int index, java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureItemsIsMutable();
        items_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string items = 2;</code>
       * @param value The items to add.
       * @return This builder for chaining.
       */
      public Builder addItems(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  ensureItemsIsMutable();
        items_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string items = 2;</code>
       * @param values The items to add.
       * @return This builder for chaining.
       */
      public Builder addAllItems(
          java.lang.Iterable<java.lang.String> values) {
        ensureItemsIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, items_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string items = 2;</code>
       * @return This builder for chaining.
       */
      public Builder clearItems() {
        items_ = com.google.protobuf.LazyStringArrayList.EMPTY;
        bitField0_ = (bitField0_ & ~0x00000001);
        onChanged();
        return this;
      }
      /**
       * <code>repeated string items = 2;</code>
       * @param value The bytes of the items to add.
       * @return This builder for chaining.
       */
      public Builder addItemsBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        ensureItemsIsMutable();
        items_.add(value);
        onChanged();
        return this;
      }

      private java.lang.Object description_ = "";
      /**
       * <code>string description = 3;</code>
       * @return The description.
       */
      public java.lang.String getDescription() {
        java.lang.Object ref = description_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          description_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string description = 3;</code>
       * @return The bytes for description.
       */
      public com.google.protobuf.ByteString
          getDescriptionBytes() {
        java.lang.Object ref = description_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          description_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string description = 3;</code>
       * @param value The description to set.
       * @return This builder for chaining.
       */
      public Builder setDescription(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        description_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string description = 3;</code>
       * @return This builder for chaining.
       */
      public Builder clearDescription() {
        
        description_ = getDefaultInstance().getDescription();
        onChanged();
        return this;
      }
      /**
       * <code>string description = 3;</code>
       * @param value The bytes for description to set.
       * @return This builder for chaining.
       */
      public Builder setDescriptionBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        description_ = value;
        onChanged();
        return this;
      }

      private float price_ ;
      /**
       * <code>float price = 4;</code>
       * @return The price.
       */
      public float getPrice() {
        return price_;
      }
      /**
       * <code>float price = 4;</code>
       * @param value The price to set.
       * @return This builder for chaining.
       */
      public Builder setPrice(float value) {
        
        price_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>float price = 4;</code>
       * @return This builder for chaining.
       */
      public Builder clearPrice() {
        
        price_ = 0F;
        onChanged();
        return this;
      }

      private java.lang.Object destination_ = "";
      /**
       * <code>string destination = 5;</code>
       * @return The destination.
       */
      public java.lang.String getDestination() {
        java.lang.Object ref = destination_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          destination_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string destination = 5;</code>
       * @return The bytes for destination.
       */
      public com.google.protobuf.ByteString
          getDestinationBytes() {
        java.lang.Object ref = destination_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          destination_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string destination = 5;</code>
       * @param value The destination to set.
       * @return This builder for chaining.
       */
      public Builder setDestination(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        destination_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string destination = 5;</code>
       * @return This builder for chaining.
       */
      public Builder clearDestination() {
        
        destination_ = getDefaultInstance().getDestination();
        onChanged();
        return this;
      }
      /**
       * <code>string destination = 5;</code>
       * @param value The bytes for destination to set.
       * @return This builder for chaining.
       */
      public Builder setDestinationBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        destination_ = value;
        onChanged();
        return this;
      }
      @java.lang.Override
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.setUnknownFields(unknownFields);
      }

      @java.lang.Override
      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return super.mergeUnknownFields(unknownFields);
      }


      // @@protoc_insertion_point(builder_scope:ecommerce.Order)
    }

    // @@protoc_insertion_point(class_scope:ecommerce.Order)
    private static final ecommerce.OrderManagementOuterClass.Order DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new ecommerce.OrderManagementOuterClass.Order();
    }

    public static ecommerce.OrderManagementOuterClass.Order getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Order>
        PARSER = new com.google.protobuf.AbstractParser<Order>() {
      @java.lang.Override
      public Order parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
        return new Order(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Order> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Order> getParserForType() {
      return PARSER;
    }

    @java.lang.Override
    public ecommerce.OrderManagementOuterClass.Order getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ecommerce_Order_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ecommerce_Order_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\026order_management.proto\022\tecommerce\032\036goo" +
      "gle/protobuf/wrappers.proto\"[\n\005Order\022\n\n\002" +
      "id\030\001 \001(\t\022\r\n\005items\030\002 \003(\t\022\023\n\013description\030\003" +
      " \001(\t\022\r\n\005price\030\004 \001(\002\022\023\n\013destination\030\005 \001(\t" +
      "2\211\001\n\017OrderManagement\022:\n\010addOrder\022\020.ecomm" +
      "erce.Order\032\034.google.protobuf.StringValue" +
      "\022:\n\010getOrder\022\034.google.protobuf.StringVal" +
      "ue\032\020.ecommerce.Orderb\006proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          com.google.protobuf.WrappersProto.getDescriptor(),
        });
    internal_static_ecommerce_Order_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_ecommerce_Order_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ecommerce_Order_descriptor,
        new java.lang.String[] { "Id", "Items", "Description", "Price", "Destination", });
    com.google.protobuf.WrappersProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
