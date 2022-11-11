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
    dataIndex: 'shape'
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
    title: '销售地区',
    align:"center",
    dataIndex: 'salesTerritory'
   },
   {
    title: '产品概述',
    align:"center",
    dataIndex: 'productOverview'
   },
   {
    title: '结构',
    align:"center",
    dataIndex: 'structure'
   },
   {
    title: '特征',
    align:"center",
    dataIndex: 'characteristic'
   },
   {
    title: '效果图',
    align:"center",
    dataIndex: 'designSketch'
   },
   {
    title: '主图',
    align:"center",
    dataIndex: 'mainMap'
   },
   {
    title: '测量方法',
    align:"center",
    dataIndex: 'measuringMethod'
   },
   {
    title: '误差',
    align:"center",
    dataIndex: 'error'
   },
   {
    title: '定额用料',
    align:"center",
    dataIndex: 'quotaMaterials'
   },
   {
    title: '折叠搭配及包装',
    align:"center",
    dataIndex: 'foldingPackaging'
   },
   {
    title: '配件及标志',
    align:"center",
    dataIndex: 'accLogos'
   },
   {
    title: '缝纫形式',
    align:"center",
    dataIndex: 'sewingForm'
   },
   {
    title: '企业id',
    align:"center",
    dataIndex: 'enterpriseId'
   },
   {
    title: '创建时间',
    align:"center",
    dataIndex: 'createTime'
   },
   {
    title: '更新时间',
    align:"center",
    dataIndex: 'updateTime'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '服装类型id',
    field: 'clothsTypeId',
    component: 'Input',
  },
  {
    label: '形式',
    field: 'shape',
    component: 'InputNumber',
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
    component: 'Input',
  },
  {
    label: '产品概述',
    field: 'productOverview',
    component: 'Input',
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
    component: 'Input',
  },
  {
    label: '主图',
    field: 'mainMap',
    component: 'Input',
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
    component: 'Input',
  },
  {
    label: '配件及标志',
    field: 'accLogos',
    component: 'Input',
  },
  {
    label: '缝纫形式',
    field: 'sewingForm',
    component: 'Input',
  },
  {
    label: '企业id',
    field: 'enterpriseId',
    component: 'Input',
  },
  {
    label: '创建时间',
    field: 'createTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
  },
  {
    label: '更新时间',
    field: 'updateTime',
    component: 'DatePicker',
    componentProps: {
       showTime: true,
       valueFormat: 'YYYY-MM-DD HH:mm:ss'
     },
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