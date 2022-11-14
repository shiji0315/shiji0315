import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '服装类型id',
    align:"center",
    dataIndex: 'clothsTypeId'
   },
   {
    title: '形式',
    align:"center",
    dataIndex: 'shape_dictText'
   },
   {
    title: '编号',
    align:"center",
    dataIndex: 'nums'
   },
   {
    title: '名称',
    align:"center",
    dataIndex: 'styleNames'
   },
   {
    title: '规格',
    align:"center",
    dataIndex: 'specification'
   },
   {
    title: '企业id',
    align:"center",
    dataIndex: 'enterpriseId'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "形式",
      field: 'shape',
      component: 'JDictSelectTag',
      componentProps:{
          dictCode:"style_shape"
      },
      colProps: {span: 6},
 	},
	{
      label: "编号",
      field: 'nums',
      component: 'Input',
      colProps: {span: 6},
 	},
	{
      label: "名称",
      field: 'styleNames',
      component: 'Input',
      colProps: {span: 6},
 	},
	{
      label: "规格",
      field: 'specification',
      component: 'Input',
      colProps: {span: 6},
 	},
	{
      label: "企业id",
      field: 'enterpriseId',
      component: 'Input',
      colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '服装类型id',
    field: 'clothsTypeId',
    component: 'JPopup',
    componentProps: ({ formActionType }) => {
        const {setFieldsValue} = formActionType;
        return{
            setFieldsValue:setFieldsValue,
            code:"cloths_type",
            fieldConfig: [
                { source: 'nums', target: 'nums' },
                { source: 'type_name', target: 'type_name' },
                { source: 'enterprise_id', target: 'enterprise_id' },
                { source: 'pid', target: 'pid' },
            ],
            multi:true
        }
    },

  },
  {
    label: '形式',
    field: 'shape',
    component: 'JDictSelectTag',
    componentProps:{
        dictCode:"style_shape"
     },
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入形式!'},
          ];
     },
  },
  {
    label: '编号',
    field: 'nums',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入编号!'},
          ];
     },
  },
  {
    label: '名称',
    field: 'styleNames',
    component: 'Input',
    dynamicRules: ({model,schema}) => {
          return [
                 { required: true, message: '请输入名称!'},
          ];
     },
  },
  {
    label: '规格',
    field: 'specification',
    component: 'Input',
  },
  {
    label: '销售地区',
    field: 'salesTerritory',
    component: 'InputTextArea',
  },
  {
    label: '产品概述',
    field: 'productOverview',
    component: 'InputTextArea',
  },
  {
    label: '结构',
    field: 'structure',
    component: 'Input',
  },
  {
    label: '特征',
    field: 'characteristic',
    component: 'Input',
  },
  {
    label: '效果图',
    field: 'designSketch',
     component: 'JImageUpload',
     componentProps:{
      },
  },
  {
    label: '主图',
    field: 'mainMap',
     component: 'JImageUpload',
     componentProps:{
      },
  },
  {
    label: '测量方法',
    field: 'measuringMethod',
    component: 'Input',
  },
  {
    label: '误差',
    field: 'error',
    component: 'Input',
  },
  {
    label: '定额用料',
    field: 'quotaMaterials',
    component: 'Input',
  },
  {
    label: '折叠搭配及包装',
    field: 'foldingPackaging',
    component: 'InputTextArea',
  },
  {
    label: '配件及标志',
    field: 'accLogos',
    component: 'InputTextArea',
  },
  {
    label: '缝纫形式',
    field: 'sewingForm',
    component: 'InputTextArea',
  },
  {
    label: '企业id',
    field: 'enterpriseId',
    component: 'Input',
  },
	// TODO 主键隐藏字段，目前写死为ID
	{
	  label: '',
	  field: 'id',
	  component: 'Input',
	  show: false
	},
];



/**
* 流程表单调用这个方法获取formSchema
* @param param
*/
export function getBpmFormSchema(_formData): FormSchema[]{
  // 默认和原始表单保持一致 如果流程中配置了权限数据，这里需要单独处理formSchema
  return formSchema;
}