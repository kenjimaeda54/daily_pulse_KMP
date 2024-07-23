//
//  RowItemPlataform.swift
//  iosApp
//
//  Created by kenjimaeda on 23/07/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct RowItemPlataform: View {
	let item: ItemsPlatform
	var body: some View {
		VStack(alignment: .leading){
			Text(item.description)
				.fontWeight(.bold)
				.font(.system(size: 17))
			Text(item.value)
				.fontWeight(.light)
				.font(.system(size: 17))
 		}
		.padding(EdgeInsets(top: 20, leading: 0, bottom: 0, trailing: 0))
		
	}
}


