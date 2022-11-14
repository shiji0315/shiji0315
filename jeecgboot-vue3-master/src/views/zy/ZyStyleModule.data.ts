import {BasicColumn} from '/@/components/Table';
import {FormSchema} from '/@/components/Table';
import { rules} from '/@/utils/helper/validator';
import { render } from '/@/utils/common/renderUtils';
//列表数据
export const columns: BasicColumn[] = [
   {
    title: '服装类型id',
    align:"center",
    dataIndex: 'clothsTypeId_dictText'
   },
   {
    title: '款式id',
    align:"center",
    dataIndex: 'styleId_dictText'
   },
   {
    title: '模块id',
    align:"center",
    dataIndex: 'modularId_dictText'
   },
   {
    title: '创建时间',
    align:"center",
    dataIndex: 'createTime'
   },
];
//查询数据
export const searchFormSchema: FormSchema[] = [
	{
      label: "服装类型id",
      field: 'clothsTypeId',
      component: 'JSearchSelect',
      componentProps:{
         dict:"zy_cloths_type,nums,id"
      },
      colProps: {span: 6},
 	},
	{
      label: "款式id",
      field: 'styleId',
      component: 'JSearchSelect',
      componentProps:{
         dict:"zy_cloths_style,style_names,id"
      },
      colProps: {span: 6},
 	},
	{
      label: "模块id",
      field: 'modularId',
      component: 'JSearchSelect',
      componentProps:{
         dict:"zy_cloths_modular,modular_name,id"
      },
      colProps: {span: 6},
 	},
];
//表单数据
export const formSchema: FormSchema[] = [
  {
    label: '服装类型id',
    field: 'clothsTypeId',
    component: 'JSearchSelect',
    componentProps:{
       dict:"zy_cloths_type,nums,id"
    },
  },
  {
    label: '款式id',
    field: 'styleId',
    component: 'JSearchSelect',
    componentProps:{
       dict:"zy_cloths_style,style_names,id"
    },
  },
  {
    label: '模块id',
    field: 'modularId',
    component: 'JSearchSelect',
    componentProps:{
       dict:"zy_cloths_modular,modular_name,id"
    },
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