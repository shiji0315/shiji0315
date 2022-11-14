import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '编号',
    align:"center",
    dataIndex: 'nums'
   },
   {
    title: '模块名称',
    align:"center",
    dataIndex: 'modularName'
   },
   {
    title: '描述',
    align:"center",
    dataIndex: 'description'
   },
   {
    title: '服装类型id',
    align:"center",
    dataIndex: 'clothsTypeId_dictText'
   },
   {
    title: '部位',
    align:"center",
    dataIndex: 'place'
   },
   {
    title: '企业id',
    align:"center",
    dataIndex: 'enterpriseId'
   },
   {
    title: '图片地址',
    align:"center",
    dataIndex: 'pictureUrl',
    customRender:render.renderImage,
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '编号',
    field: 'nums',
    component: 'Input',
  },
  {
    label: '模块名称',
    field: 'modularName',
    component: 'Input',
  },
  {
    label: '描述',
    field: 'description',
    component: 'Input',
  },
  {
    label: '服装类型id',
    field: 'clothsTypeId',
    component: 'JSearchSelect',
    componentProps:{
       dict:"zy_cloths_type,nums,id"
    },
  },
  {
    label: '部位',
    field: 'place',
    component: 'InputNumber',
  },
  {
    label: '企业id',
    field: 'enterpriseId',
    component: 'Input',
  },
  {
    label: '图片地址',
    field: 'pictureUrl',
     component: 'JImageUpload',
     componentProps:{
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